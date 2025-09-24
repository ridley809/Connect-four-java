public abstract class Case {
    private Coordonnees p; // Coordonnees est un type que vous devez définir quelque part
    protected int m_type;

    //Constructeur par defaut :
    public Case() {
        this.p = new Coordonnees(); // Coordonnées par défaut (0,0)
        this.m_type = -1; // Valeur arbitraire pour une case "indéfinie"
    }

    // Constructeur avec paramètres
    public Case(Coordonnees p, int type) {
        this.p = p;
        this.m_type = type;
    }

    // Méthodes getter pour obtenir les coordonnées et le type

    public int getI(){
        return p.getI();
    }

    public int getType(){return m_type;}

    public int getJ(){
        return p.getJ();
    }

    // Déclaration de la méthode afficher() comme abstraite
    public abstract String afficher();
}