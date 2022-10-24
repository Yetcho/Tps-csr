
class Site {

/* Constantes communes à tous les sites */

 
static final int STOCK_INIT = 5;
static final int STOCK_MAX = 10;
static final int BORNE_SUP = 8;
static final int BORNE_INF = 2;


private int nb_Velo = STOCK_INIT;
private int numsite ;

    // sur un site on peut restituer, emprunter
    synchronized public void emprunter(){
        if (nb_Velo == 0){
            try {
                wait();
        } catch (Exception e) {

        }
        }
        nb_Velo--;
        System.out.println(Thread.currentThread().getName()+ " le site :"+ numsite+ " Contient : "+nb_Velo+ " apres emprunt");
        notify();
    }
    synchronized public void restituer(){
        if (nb_Velo == STOCK_MAX){
            try {
                wait();
            } catch (Exception e) {
            }
        }
        nb_Velo ++;
        System.out.println(Thread.currentThread().getName()+ " le site :"+ numsite+ " Contient : "+nb_Velo +" apres restitution");
        notify();
    }

    public Site(int numsite){
        this.numsite = numsite;
    }
    
    public int getNumSite(){
        return numsite;
    }
//on sait que de base le camion vient avec des velo dans son camion
    public void equilib(int Velo_present_camion){
        //velo excédentaire (nbvelo sur le site et stock initiale)
        int cpt=0;
        numsite=0;

        if(nb_Velo >= BORNE_SUP){
            cpt = nb_Velo - STOCK_INIT;
            for(int i=0; i<= cpt; i++){
                emprunter();
            }
            Velo_present_camion = Velo_present_camion+cpt;
            numsite++; 
            System.out.println(Thread.currentThread().getName()+ " le site :"+ numsite+ " le camion à Recuperer : "+cpt);
        }else if(nb_Velo <= BORNE_INF){
            cpt = STOCK_INIT -nb_Velo;
            //le camion satisfait le site
            if(Velo_present_camion >= cpt){
                for(int i=0 ; i<= cpt; i++){
                    restituer();
                }
                Velo_present_camion =  Velo_present_camion-cpt;
                numsite ++;
                System.out.println(Thread.currentThread().getName()+ " le site :"+ numsite+ " le camion à Restituer : "+cpt);
                //le camion ne peut pas satisfait le site si la demande du site cpt est inferieur à ce que le camion peut offrir
            }else{
                for(int i=0; i<= cpt; i++){
                    restituer();
                }
                Velo_present_camion =0;
                numsite++;
                System.out.println(Thread.currentThread().getName()+ " le site :"+ numsite+ " le camion à Restituer : "+cpt);
                }
            
        }

    }
}
