import java.util.HashMap;
public class Grille {

    // Attributs privés
    private int m_largeur; // Largeur de la grille (nombre de colonnes)
    private int m_hauteur; // Hauteur de la grille (nombre de lignes)
    private HashMap<Coordonnees, Case> cases; // Stocke les cases avec leurs coordonnées comme clé

    // Constructeur par défaut (initialise une grille de 7 colonnes × 6 lignes)
    public Grille() {
        this.m_largeur = 7;
        this.m_hauteur = 6;
        this.cases = new HashMap<>();
        for (int i = 0; i < m_hauteur; i++) {
            for (int j = 0; j < m_largeur; j++) {
                cases.put(new Coordonnees(i, j), new CaseVide(new Coordonnees(i, j)));
            }
        }
    }

    //Constructeur paramétré : permet de créer une grille avec des dimensions personnalisées
    public Grille(int largeur, int hauteur) {
        this.m_hauteur = hauteur;
        this.m_largeur = largeur;
        this.cases = new HashMap<>();
        for (int i = 0; i < m_hauteur; i++) {
            for (int j = 0; j < m_largeur; j++) {
                cases.put(new Coordonnees(i, j), new CaseVide(new Coordonnees(i, j)));
            }
        }
    }

    // Méthode pour placer une case à une position donnée dans la grille
    public void setCase(int i, int j, Case c) {
        if (i >= 0 && i < m_hauteur && j >= 0 && j < m_largeur) {         // Vérifie que les indices sont valides avant d'insérer la case
            Coordonnees coord = new Coordonnees(i, j); // Crée un objet Coordonnees pour l'emplacement
            cases.put(coord, c); // Insère la case dans la HashMap
        }
    }

    // Méthode pour récupérer une case à une position donnée
    public Case getCase(int i, int j) {
        Coordonnees coord = new Coordonnees(i, j);
        Case caseActuelle = cases.get(coord);
        if (caseActuelle == null) {
            return new CaseVide(coord);
        }
        return caseActuelle;
    }

    // Vérifie si la grille est complètement remplie
    public Boolean pleine() {
        for (int i = 0; i < m_hauteur; i++) {
            for (int j = 0; j < m_largeur; j++) {
                Coordonnees coord = new Coordonnees(i, j);
                // Si une case est vide, la grille n'est pas pleine
                if (cases.get(coord) instanceof CaseVide) {
                    return false; // Il reste au moins une case vide
                }
            }
        }
        return true; // Aucune case vide trouvée, donc la grille est pleine

    }

    // Affiche la grille en console
    public void afficher() {

        System.out.print("    ");
        for (int j = 0; j < m_largeur; j++) {
            System.out.print(" " + j + "  ");  // Afficher les numéros de colonne
        }
        System.out.print("\n");

        System.out.print("   ");
        for (int j = 0; j < m_largeur; j++) {
            System.out.print("----");  // Créer un séparateur pour chaque colonne
        }
        System.out.print("\n");

        for (int i = 0; i < m_hauteur; i++) {
            System.out.print(" " + i + " |");

            // Afficher les cases de la ligne
            for (int j = 0; j < m_largeur; j++) {
                System.out.print(" " + getCase(i, j).afficher() + " |");  // Afficher la case avec un espace autour
            }
            System.out.print("\n");

            System.out.print("   ");
            for (int j = 0; j < m_largeur; j++) {
                System.out.print("----");  // Créer un séparateur entre les lignes
            }
            System.out.print("\n");
        }
    }


}
