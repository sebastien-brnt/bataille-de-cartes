package bataille;

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

    public int getNbCartes() {
        return this.tabCarte.length;
    }

    public String toString() {
        return "bataille.Joueur{" +
                "tabCarte=" + Arrays.toString(tabCarte) +
                '}';
    }


    //****** Autres méthodes ******//
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

    public void addCarte(Carte carte, int index) {
        // Si la valeur est 999 on ajoute en dessous du paquet, sinon on empile
        if (index == 999) {
            int length = tabCarte.length + 1;
            Carte[] nouveautabCarte = new Carte[length];
            nouveautabCarte[0] = carte;
            System.arraycopy(tabCarte, 0, nouveautabCarte, 1, tabCarte.length);
            this.tabCarte = nouveautabCarte;
        } else {
            this.tabCarte[index] = carte;
        }
    }
}
