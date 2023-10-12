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

        // Initialisation du paquet en cas d'égalité
        Carte[] paquetEgalite = new Carte[0];

        // Partie de Bataille jusqu'à ce qu'un des deux joueurs n'est plus de cartes
        while (joueur1.getCartes().length > 0 && joueur2.getCartes().length > 0) {
            // Tirage des carte des 2 joueurs
            Carte carte1 = joueur1.tireCarte();
            Carte carte2 = joueur2.tireCarte();

            // Affichage des cartes tiré
            System.out.println("");
            System.out.println("Joueur 1 : " + carte1.toString());
            System.out.println("Joueur 2 : " + carte2.toString());

            // Comparaison des deux cartes
            int resultatRound = carte1.compare(carte2);

            if (resultatRound == 1) {
                // Récupération de sa carte et celle de l'adversaire
                joueur1.addCarte(carte1, 999);
                joueur1.addCarte(carte2, 999);

                // Si le paquet égalité contient des cartes, le joueur le récupère
                if (paquetEgalite.length > 0) {
                    for (int i = 0; i < paquetEgalite.length; i++) {
                       joueur1.addCarte(paquetEgalite[i], 999);
                    }
                    paquetEgalite = new Carte[0];
                }

                // Ajout du point
                System.out.println(joueur1.addPoint() + " 1");

            } else if (resultatRound == 2) {
                // Récupération de sa carte et celle de l'adversaire
                joueur2.addCarte(carte2, 999);
                joueur2.addCarte(carte1, 999);

                // Si le paquet égalité contient des cartes, le joueur le récupère
                if (paquetEgalite.length > 0) {
                    for (int i = 0; i < paquetEgalite.length; i++) {
                        joueur2.addCarte(paquetEgalite[i], 999);
                    }
                    paquetEgalite = new Carte[0];
                }

                // Ajout du point
                System.out.println(joueur2.addPoint() + " 2");

            } else {
                // Création nouveau tableau avec une longeur plus grand de 2
                Carte[] nouveauPaquetEgalite = new Carte[paquetEgalite.length + 2];

                // Si le tableau contient des cartes, on copie les cartes de l'ancien tableau
                if (paquetEgalite.length > 0) {
                    for (int i = 0; i < paquetEgalite.length; i++) {
                        nouveauPaquetEgalite[i] = paquetEgalite[i];
                    }
                }

                // Ajout des 2 cartes
                nouveauPaquetEgalite[paquetEgalite.length] = carte1;
                nouveauPaquetEgalite[paquetEgalite.length + 1] = carte2;

                // Remplacement de l'ancien tableau par le nouveau est affichage du message d'égalité
                paquetEgalite = nouveauPaquetEgalite;
                System.out.println("Égalité, pas de point attribué");
            }

            // Affichage du score
            System.out.println("Les scores sont de : J1 " + joueur1.getPoints() + " à J2 " + joueur2.getPoints());
        }

        // Espacement avant l'affichage du résultat
        System.out.println("\n");

        // Résultats de la bataille
        if (joueur1.getPoints() > joueur2.getPoints()) {
            System.out.println("Le gagnant est le Joueur 1 avec le score de J1 " + joueur1.getPoints() + " à J2 " + joueur2.getPoints());

        } else if (joueur1.getPoints() < joueur2.getPoints()) {
            System.out.println("Le gagnant est le Joueur 2 avec le score de J2 " + joueur2.getPoints() + " à J1 " + joueur1.getPoints());

        } else {
            // En cas d'égalité de point, on vérifie quel joueur n'a plus de carte et on définit l'autre joueur gagnant
            if (joueur1.getNbCartes() == 0 && joueur1.getNbCartes() < joueur2.getNbCartes()) {
                System.out.println("Le gagnant est le Joueur 2 avec le score de J2 " + joueur2.getPoints() + " à J1 " + joueur1.getPoints() + " car J1 n'a plus de carte");

            } else if (joueur2.getNbCartes() == 0 && joueur2.getNbCartes() < joueur1.getNbCartes()) {
                System.out.println("Le gagnant est le Joueur 1 avec le score de J1 " + joueur1.getPoints() + " à J2 " + joueur2.getPoints() + " car J2 n'a plus de carte");

            } else {
                // Si les deux joueur ont le même score et n'ont plus de carte tout les deux
                System.out.println("Il n'y a pas vainqueur, le score est le même pour les deux joueurs");
            }
        }
    }
}