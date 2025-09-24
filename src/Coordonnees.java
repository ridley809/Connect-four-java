import java.util.Objects;

public class Coordonnees {

    //attributs privés
    private int m_i;
    private int m_j;

    // constructeur privé, initialise les coordonnées à (0,0)
    public Coordonnees() {
        this.m_i = 0;
        this.m_j = 0;
    }

    // constructeur paramétré
    Coordonnees(int i, int j){
        this.m_i = i;
        this.m_j = j;

    }

    // méthodes getter qui renvoie respectivement l'attribut m_i et m_j
    public int getI(){
        return m_i;
    }

    public int getJ(){
        return m_j;
    }

    // méthodes setter pour les deux attributs :
    public void setI(int i){

        this.m_i = i;
    }
    public void setJ(int j){

        this.m_j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordonnees that = (Coordonnees) o;
        return m_i == that.m_i && m_j == that.m_j;
    }

    // Méthode hashCode() basée sur m_i et m_j
    @Override
    public int hashCode() {
        return Objects.hash(m_i, m_j);
    }
}


