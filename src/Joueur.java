import java.util.Arrays;

public class Joueur {

    // Attributs du joueur
    private Carte[] tabCarte;
    private int points;

    // Constructeur
    Joueur() {
        this.tabCarte = new Carte[26];
        this.points = 0;
    }


    //****** Getters ******//
    public int getPoints() {

        return this.points;
    }

    public Carte[] getCartes() {
        return this.tabCarte;
    }


    //****** Autres fonctions ******//
    public Carte tireCarte() {
        if (tabCarte.length > 0) {
            Carte derniereCarte = tabCarte[tabCarte.length - 1];
            tabCarte[tabCarte.length - 1] = null;

            Carte[] nouveautabCarte = new Carte[tabCarte.length - 1];
            System.arraycopy(tabCarte, 0, nouveautabCarte, 0, tabCarte.length - 1);
            tabCarte = nouveautabCarte;

            return derniereCarte;
        }
        return null;
    }

    public String addPoint() {
        this.points++;
        return "Point attribué au joueur";
    }

    public String toString() {
        return "Joueur{" +
                "tabCarte=" + Arrays.toString(tabCarte) +
                '}';
    }

    public void addCarte(Carte carte, int index) {
        if (index == 100) {
            int length = tabCarte.length + 1;
            Carte[] nouveautabCarte = new Carte[length];
            nouveautabCarte[0] = carte; // Placez la nouvelle carte en première position
            System.arraycopy(tabCarte, 0, nouveautabCarte, 1, tabCarte.length); // Décalez les éléments existants vers la droite
            this.tabCarte = nouveautabCarte;
        } else {
            this.tabCarte[index] = carte;
        }
    }
}
