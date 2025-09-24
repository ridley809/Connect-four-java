public class CaseVide extends Case{

    // constructeur par défaut, on le définit en appelant le constructeur paramétré de la classe Case
    // pour pouvoir initialiser et fixé le type = 0

    public CaseVide() {
        super(new Coordonnees(), 0);
    }


    public CaseVide(Coordonnees p) {
        super(p, 0); // Appelle le constructeur de Case avec les bonnes valeurs
    }

    // Affiche un espace vide car CaseVide :
    public String afficher(){
        return " ";
    }
}
