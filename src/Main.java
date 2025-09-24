import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Partie partie; // Déclaration de la partie

        System.out.println("Souhaitez-vous jouer avec la grille de base 7x6 ? (oui/non)");
        String reponse = scanner.nextLine().trim().toLowerCase();

        switch (reponse) {
            case "oui":
                partie = new Partie(); // Appel du constructeur par défaut
                System.out.println("Vous avez choisi la grille par défaut (7x6) avec 4 pions à aligner.");
                break;

            case "non":
                int largeur, hauteur;
                // Vérifier que la largeur est supérieure à 4
                do {
                    System.out.print("Entrez la largeur de la grille (supérieure à 4) : ");
                    largeur = scanner.nextInt();
                    if (largeur < 5) {
                        System.out.println("La largeur doit être strictement supérieure à 4.");
                    }
                } while (largeur < 5);

                // Vérifier que la hauteur est supérieure à 4
                do {
                    System.out.print("Entrez la hauteur de la grille (supérieure à 4) : ");
                    hauteur = scanner.nextInt();
                    if (hauteur < 5) {
                        System.out.println("La hauteur doit être strictement supérieure à 4.");
                    }
                } while (hauteur < 5);

                int pions;

                do { //boucle pour verifier que le nombre de pions soit bien inférieur a la taille du plateau
                    System.out.print("Combien de pions doivent être alignés pour gagner ? ");
                    pions = scanner.nextInt();
                    if (pions >= largeur || pions >= hauteur) {
                        System.out.println("Erreur : Le nombre de pions à aligner doit être strictement inférieur à la largeur et à la hauteur.");
                    }
                } while (pions >= largeur || pions >= hauteur);

                partie = new Partie(largeur, hauteur, pions); // Appel du constructeur personnalisé de plateau
                break;


            default:
                System.out.println("Réponse non reconnue, la grille par défaut sera utilisée.");
                partie = new Partie(); // Par défaut, on utilise la grille 7x6.
                break;
        }

        System.out.println("La partie commence avec une grille de " + partie.getLargeur() + "x" + partie.getHauteur() +
                " et " + partie.getNbPionsAAligner() + " pions à aligner !");


        boolean finie = partie.partieFinie();
        // Boucle principale du jeu
        while (!finie) { // Vérification dynamique
            // Afficher la grille de jeu
            partie.afficher();
            // Demander au joueur actuel de choisir une colonne
            System.out.println("Tour du joueur " + partie.getJoueur() + " : Saisir la colonne dans laquelle jouer (0 à " + (partie.getLargeur() - 1) + ") : ");
            int colonne = scanner.nextInt();
            // Vérifier si la colonne est valide
            if (colonne < 0 || colonne >= partie.getLargeur()) {
                System.out.println("Colonne invalide ! Veuillez réessayer.");
            } else if (!partie.coupPossible(colonne)) {
                // Vérifier si la colonne est pleine
                System.out.println("Colonne pleine ! Veuillez réessayer.");
            } else {
                partie.jouer(colonne); // Jouer le coup
                finie = partie.partieFinie(); // Mettre à jour l'état de la partie immédiatement
                partie.changerJoueur(); // on change le joueur apres son tour
            }
        }

        // Affichage final
        partie.afficher();

        scanner.close();
    }
}