package bataille;

public class Carte {
    // Attributs de la carte
    private String couleur;
    private String valeur;

    // Tableaux statiques des couleurs et valeurs
    private static final String[] COULEURS = {"Coeur", "Carreau", "Trèfle", "Pique"};
    private static final String[] VALEURS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};

    // Constructeur
    public Carte(String couleur, String valeur) {
        if (isValidCouleur(couleur)) {
            this.couleur = couleur;
        } else {
            throw new IllegalArgumentException("La couleur est invalide ! Couleurs disponibles : Coeur, Carreau, Trèfle, Pique");
        }

        if (isValidValeur(valeur)) {
            this.valeur = valeur;
        } else {
            throw new IllegalArgumentException("La valeur est invalide ! Valeurs disponibles : 2, 3, 4, 5, 6, 7, 8, 9, 10, Valet, Dame, Roi, As");
        }

    }


    //****** Getters ******//
    public static String[] getCouleurs() {
        return COULEURS;
    }

    public static String[] getValeurs() {
        return VALEURS;
    }

    public String getCouleurCarte() {
        return couleur;
    }

    public String getValeurCarte() {
        return valeur;
    }

    //****** Setters ******//
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    //****** Autres fonctions ******//
    // Vérification de l'existance de la couleur dans le tableau static des couleurs
    private boolean isValidCouleur(String couleur) {
        for (String couleurValide : COULEURS) {
            if (couleurValide.equals(couleur)) {
                return true;
            }
        }
        return false;
    }

    // Vérification de l'existance de la valeur dans le tableau static des valeurs
    private boolean isValidValeur(String valeur) {
        for (String valeurValide : VALEURS) {
            if (valeurValide.equals(valeur)) {
                return true;
            }
        }
        return false;
    }

    // Transforme la carte en string
    public String toString() {
        return this.valeur + " de " + this.couleur;
    }

    // Récupère la valeur des cartes par rapport à leur index
    private int getValeurIndex() {
        for (int i = 0; i < VALEURS.length; i++) {
            if (valeur.equals(VALEURS[i])) {
                return i;
            }
        }
        return -1;
    }

    // Compare les valeurs de 2 cartes
    public int compare(Carte carte) {
        int valeurCarte1 = this.getValeurIndex();
        int valeurCarte2 = carte.getValeurIndex();

        if (valeurCarte1 > valeurCarte2) {
            return 1;
        } else if (valeurCarte1 == valeurCarte2) {
            return 0;
        } else {
            return 2;
        }
    }
}
