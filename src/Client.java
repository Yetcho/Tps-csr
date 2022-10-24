
public class Client extends Thread {
    
    private Site site;
    private Site site2;


    public Client(Site site, Site site2) {
        this.site =site;
        this.site2 = site2;
    }

    public void run(){
        //site de départ il emprunt 
        site.emprunter();
        try {
            //La duree de ce trajet sera proportionnelle `a la distance entre le sites2 et le site 
            Thread.sleep(100*(Math.abs(site2.getNumSite()-site.getNumSite())));
        } catch (Exception e) {
            
        }
        // site2 il restitue
        site2.restituer();
    }

}
