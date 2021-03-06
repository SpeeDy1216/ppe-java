package file;

import java.util.Date;

public class Colloque {

    private long num_col = 0;
    private String intitule = "";
    private String description = "";
    private String date_debut;
    private int nb_de_part = 0;

    public Colloque() {
    }

    public Colloque(long num_col, String intitule, String date_debut,
            int nb_de_part, String description) {
        super();
        this.num_col = num_col;
        this.intitule = intitule;
        this.description = description;
        this.date_debut = date_debut;
        this.nb_de_part = nb_de_part;
    }
    
     public Colloque(String intitule, String date_debut, int nb_de_part, String description) {
        this.intitule = intitule;
        this.date_debut = date_debut;
        this.nb_de_part = nb_de_part;
        this.description=description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public long getNum_col() {
        return num_col;
    }

    public void setNum_col(long num_col) {
        this.num_col = num_col;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public int getNb_de_part() {
        return nb_de_part;
    }

    public void setNb_de_part(int nb_de_part) {
        this.nb_de_part = nb_de_part;
    }

    @Override
    public String toString() {
        return "Colloque [intitule=" + this.intitule + ", date_debut=" + this.date_debut
                + ", nb_de_part=" + this.nb_de_part + "]";
    }

}
