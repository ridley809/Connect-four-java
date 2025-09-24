public class CaseRouge extends Case{

    // constructeur par défaut, on le définit en appelant le constructeur paramétré de la classe Case
    // pour pouvoir initialiser et fixé le type = 2

    public CaseRouge() {
        super(new Coordonnees(), 2); // Initialise m_type directement à 2
    }

    // Constructeur paramétré : Appelle le constructeur de Case avec les bonnes valeurs
    public CaseRouge(Coordonnees p) {
        super(p, 2);
    }


    // Affiche 0 car CaseRouge :

    public String afficher(){
        return "O";
    }
}
