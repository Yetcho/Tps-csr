s// PENSEZ A INDIQUER PAR DES COMMENTAIRES LES MODIFICATIONS APPORTEES A CE SQUELETTE AU FUR
// ET A MESURE DE L'EVOLUTION DU CODE DEMANDEE DANS LE TP.

/**
 * Les objets instances de la classe Usine represente une usine avec deux ateliers.
 * Une instance d'Usine possede un stock de pieces a transformer ainsi qu'un stock
 * de pieces finies initialement vide. Chacun des deux ateliers transforme la moitie
 * des unites du stock a transformer.
 * La methode fonctionner() fait travailler successivement les deux ateliers et affiche
 * l'etat des stocks a la fin des travaux.
 */
class Usine {
	/**
	 * Stock de pieces a transformer
	 */
    Stock stockDepart = new Stock("de depart", 10);
    /**
     * Stock de pieces transformees
     */
    Stock stockFin = new Stock("d'arrivee", 0);
    /**
     * Ateliers de transformation
     */
    Atelier atelier1 = new Atelier(stockDepart, stockFin, 5);
    Atelier atelier2 = new Atelier(stockDepart, stockFin, 5);

    /**
     * Effectuer le travail de l'usine
     * Utilise successivement chaque atelier pour transformer une piece et affiche
     * l'evolution de l'etat des stocks.
     */
    public void fonctionner() {
    		atelier1.travailler();
    		atelier2.travailler();
    		stockDepart.afficher();
    		stockFin.afficher();
    }

    /**
     * Point d'entree pour l'ensemble du TP.
     * @param args Non utilise
     */
    public static void main(String[] args) {



    }
}
