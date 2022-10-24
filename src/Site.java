
class Site {

/* Constantes communes à tous les sites */

 
static final int STOCK_INIT = 5;
static final int STOCK_MAX = 10;
static final int BORNE_SUP = 8;
static final int BORNE_INF = 2;


private int nb_Velo = STOCK_INIT;
private int numsite ;

public Site(int numsite){
    this.numsite = numsite;
}

public int getNumSite(){
    return numsite;
}

    // sur un site on peut restituer, emprunter
    synchronized public void emprunter(){
        if (nb_Velo == 0){
           try {
            wait();
           } catch (Exception e) {
            // TODO: handle exception
           }
        }
        nb_Velo--;
    }
    synchronized public void restituer(){
        if (nb_Velo == Site.STOCK_MAX){
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        nb_Velo ++;
    }

    public void equilib(int Velo_present_camion){
        //velo excédentaire
        int cpt=0;
        numsite=0;

        if(nb_Velo >= BORNE_SUP){
            cpt = nb_Velo - STOCK_INIT;
            for(int i=0; i<= cpt; i++){
                emprunter();
            }
            Velo_present_camion +=cpt;
            numsite++; 
        }else{
            if(nb_Velo <= BORNE_INF){
                cpt = STOCK_INIT -nb_Velo;
                if(Velo_present_camion >= cpt){
                    for(int i=0 ; i<= cpt; i++){
                        restituer();
                    }
                    Velo_present_camion -= cpt;
                    numsite ++;
                }else{
                    for(int i=0; i<= Velo_present_camion; i++){
                        restituer();
                    }
                    Velo_present_camion =0;
                    numsite++;
                }
            }
        }

    }
}
