
public class Camion extends Thread{
    private Site[] sites;
    private int Velo_present_camion;

    public Camion(Site[] sites) {
        this.sites = sites;
        this.Velo_present_camion =0;
    }

    public void deplacer(){
        int i =0;
        while(i < sites.length){
            sites[i].equilib(Velo_present_camion);
            if(i==(sites.length-1)) {
				try {
					Thread.sleep(100*(sites[i].getNumSite()));
				} catch (Exception e) {
					
				}
            }else{
                try {
                   Thread.sleep(100*(Math.abs(sites[i].getNumSite()-sites[i+1].getNumSite())));
                } catch (Exception e) { 
                }
            }

            i++;
        }
    }



    public void run(){
        deplacer();
    }




}
