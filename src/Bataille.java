public class Bataille {
    public static void main(String[] arg) {

        // Création des 2 joueurs
        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();

        // Initialisation du paquet de 52 cartes
        Carte[] paquet = new Carte[Carte.getCouleurs().length * Carte.getValeurs().length];
        int index = 0;

        for (int i = 0; i < Carte.getCouleurs().length; i++) {
            for (int j = 0; j < Carte.getValeurs().length; j++) {
                Carte addCarte = new Carte(Carte.getCouleurs()[i], Carte.getValeurs()[j]);
                paquet[index] = addCarte;
                index++;
            }
        }

        // Mélange le paquet de 52 cartes
        for (int i = paquet.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));

            Carte temp = paquet[i];
            paquet[i] = paquet[j];
            paquet[j] = temp;
        }

        // Distibution des cartes du paquet mélangé aux 2 joueurs
        int compteurj1 = 0;
        int compteurj2 = 0;

        for (int i = 0; i < paquet.length; i++) {
            if (i % 2 == 0) {
                joueur1.addCarte(paquet[i], compteurj1);
                compteurj1++;
            } else {
                joueur2.addCarte(paquet[i], compteurj2);
                compteurj2++;
            }
        }

        // Bataille avec 26 round (car chaque joueur possède 26 cartes)
        for (int i = 26; i > 0; i--) {
            Carte carte1 = joueur1.tireCarte();
            Carte carte2 = joueur2.tireCarte();

            if (carte1 != null && carte2 != null) {
                System.out.println("");
                System.out.println("Le Joueur 1 met la carte : " + carte1.toString());
                System.out.println("Le Joueur 2 met la carte : " + carte2.toString());

                int resultatRound = carte1.compare(carte2);

                if (resultatRound == 1) {
                    System.out.println(joueur1.addPoint() + " 1");
                } else if (resultatRound == 2) {
                    System.out.println(joueur2.addPoint() + " 2");
                } else {
                    System.out.println("Pas de point attribué");
                }

                System.out.println("Le score est de : " + joueur1.getPoints() + " à " + joueur2.getPoints());
            } else {
                System.out.println("Le joueur ne possède plus de carte");
            }
        }

        // Résultats de la bataille
        System.out.println("\n");
        if (joueur1.getPoints() > joueur2.getPoints()) {
            System.out.println("Le gagnant est le Joueur 1 avec le score de " + joueur1.getPoints() + " à " + joueur2.getPoints());
        } else if (joueur1.getPoints() < joueur2.getPoints()) {
            System.out.println("Le gagnant est le Joueur 2 avec le score de " + joueur1.getPoints() + " à " + joueur2.getPoints());
        } else {
            System.out.println("Il n'y a pas vainqueur, le score est le même pour les deux joueurs");
        }

    }
}