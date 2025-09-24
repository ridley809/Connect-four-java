public class Partie {
    // Attributs privés
    private int m_hauteur; // Hauteur de la grille
    private int m_largeur; // Largeur de la grille
    private int NbPionsAAligner; // Nombre de pions à aligner pour gagner
    private Grille g;  // Grille de jeu
    private int joueur; // Joueur actuel (1 ou 2)

    // Constructeur par défaut (grille 7x6, alignement de 4 pions pour gagner)
    public Partie() {
        g = new Grille();
        this.m_largeur = 7;
        this.m_hauteur = 6;
        this.NbPionsAAligner = 4;
        this.joueur = 1;

    }
    // Constructeur avec paramètres (dimensions et condition de victoire personnalisées)
    public Partie(int largeur, int hauteur, int pions) {
        g = new Grille(largeur, hauteur);
        this.m_hauteur = hauteur;
        this.m_largeur = largeur;
        this.NbPionsAAligner = pions;
        this.joueur = 1;
    }

    // Affiche l'état actuel de la grille
    public void afficher() {
        g.afficher();
    }

    // Vérifie si la partie est finie (grille pleine ou un joueur gagne)
    public boolean partieFinie(){
        if (g.pleine()) {
            System.out.println("Match Null"); // Affiche un message si la grille est pleine
            return true; // // La partie est terminée en cas d'égalité
        } else if (gagne()) {
            System.out.println("Le Joueur " + getJoueur() + " gagne"); // Annonce le gagnant
            return true; // Partie terminée car un joueur a gagné
        }
        return false; // La partie continue
    }

    // Méthodes getter crée pour personaliser les messages dans le main
    public int getNbPionsAAligner(){
        return NbPionsAAligner;
    }

    public int getHauteur() {
        return m_hauteur;
    }

    public int getLargeur() {
        return m_largeur;
    }

    public int getJoueur() {
        return joueur;
    }

    // Vérifie si un coup est possible dans une colonne donnée
    public boolean coupPossible(int colonne) {
        Case caseActuelle = g.getCase(0, colonne);
        return (caseActuelle instanceof CaseVide);
    }

    // Change le joueur après chaque tour
    public void changerJoueur() {
            if (joueur == 1) {
                joueur = 2;
            } else {
                joueur = 1;
            }
    }

    // Permet à un joueur de jouer dans une colonne donnée
    public void jouer(int colonne) {
        int i = m_hauteur - 1;  // Commence en bas de la colonne,  on commence a m_hauteur -1 car
                                // dans notre affichage les lignes sont afficher dans le sens inverse
        // Trouve la première case vide en remontant
        while (i >= 0 && !(g.getCase(i, colonne) instanceof CaseVide)) {
            i--;
        }
        // Si une case vide est trouvée, place un pion
        if (i >= 0) {// Vérifie qu'on a trouvé une case valide
            if (joueur == 1) {
                g.setCase(i, colonne, new CaseJaune(new Coordonnees(i,colonne)));
            } else {
                g.setCase(i, colonne, new CaseRouge(new Coordonnees(i,colonne)));
            }
        }
    }

    // Vérifie si un joueur a gagné
    public boolean gagne() {
        for (int i = 0; i < m_hauteur; i++) {
            for (int j = 0; j < m_largeur; j++) {
                Case caseActuelle = g.getCase(i, j);
                if (!(caseActuelle instanceof CaseVide) && gagneLigne(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Vérifie si un alignement gagnant existe depuis une position (i, j)
    public Boolean gagneLigne(int i, int j) {
        // Vérification verticale (haut -> bas)
        int cmt = 0;
        int k = i;
        while (k >= 0 && (g.getCase(k, j)).getType() == getJoueur()) {  // Utilisation de getJoueur()
            k = k - 1;
            cmt = cmt + 1;
        }
        if (cmt >= NbPionsAAligner) {
            // Victoire
            return true; // Victoire si le nombre de pions alignés est suffisant

        }
        // Vérification horizontale (gauche <-> droite)
        cmt = 0;
        k = j;
        // gauche
        while (k >= 0 && (g.getCase(i, k)).getType() == getJoueur()) {  // Utilisation de getJoueur()
            k = k - 1;
            cmt = cmt + 1;
        }
        k = j;
        // droite
        while (k < m_largeur && (g.getCase(i, k + 1)).getType() == getJoueur()) {  // Utilisation de getJoueur()
            k = k + 1;
            cmt = cmt + 1;
        }
        if (cmt >= NbPionsAAligner) {
            // Victoire
            return true;
        }

        // Etude de victoire Diagonale de Haut Gauche -> Bas Droite
        cmt = 0;
        int k1 = i;
        int k2 = j;
        // haut gauche
        while (k1 < m_hauteur && k2 >= 0 && (g.getCase(k1, k2)).getType() == getJoueur()) {  // Utilisation de getJoueur()
            k1 = k1 + 1;
            k2 = k2 - 1;
            cmt = cmt + 1;
        }
        k1 = i;
        k2 = j;
        // bas droite
        while (k1 >= 0 && k2 < m_largeur && (g.getCase(k1 - 1, k2 + 1)).getType() == getJoueur()) {  // Utilisation de getJoueur()
            k1 = k1 - 1;
            k2 = k2 + 1;
            cmt = cmt + 1;
        }
        if (cmt >= NbPionsAAligner) {
            // Victoire
            return true;
        }

        // Etude de victoire Diagonale de Haut Droite -> Bas Gauche
        cmt = 0;
        k1 = i;
        k2 = j;
        // haut droite
        while (k1 < m_hauteur && k2 < m_largeur && (g.getCase(k1, k2)).getType() == getJoueur()) {  // Utilisation de getJoueur()
            k1 = k1 + 1;
            k2 = k2 + 1;
            cmt = cmt + 1;
        }
        k1 = i;
        k2 = j;
        // bas gauche
        while (k1 >= 0 && k2 >= 0 && (g.getCase(k1 - 1, k2 - 1)).getType() == getJoueur()) {  // Utilisation de getJoueur()
            k1 = k1 - 1;
            k2 = k2 - 1;
            cmt = cmt + 1;
        }
        if (cmt >= NbPionsAAligner) {
            // Victoire
            return true;
        }
        // Si aucune condition de victoire n'est remplie
        return false;
    }



}
