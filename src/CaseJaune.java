public class CaseJaune extends Case{

    // constructeur par défaut, on le définit en appelant le constructeur paramétré de la classe Case
    // pour pouvoir initialiser et fixé le type = 1

    public CaseJaune() {
        super(new Coordonnees(), 1); // Initialise m_type directement à 1
    }

    // Constructeur paramétré : Appelle le constructeur de Case avec les bonnes valeurs
    public CaseJaune(Coordonnees p) {
        super(p, 1);
    }

    // Affiche X car CaseJaune :

    public String afficher(){
        return "X";
    }
}
