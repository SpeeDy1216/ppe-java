package file;
import java.util.Date;

public class Personne {
        private long num_pers;
        private String num_perss;
	private String nom = "";
	private String prenom = "";
	private String date_naiss ="";
	
	public Personne(){}
        
        public Personne(long num_pers, String nom, String prenom, String date_naiss) {
                this.num_pers = num_pers;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naiss = date_naiss;
	}
        
    public Personne(String nom, String prenom, String date_naiss) {
		this.nom = nom;
		this.prenom = prenom;
		this.date_naiss = date_naiss;
	}

	public Personne(String num_pers, String nom, String prenom, String date_naiss) {
		this.num_perss = num_pers;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naiss = date_naiss;
	}

        public void setNum_pers(long num_pers) {
            this.num_pers = num_pers;
        }

        public long getNum_pers() {
            return num_pers;
        }
    
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(String date_naiss) {
		this.date_naiss = date_naiss;
	}

	@Override
	public String toString() {
		return "Personne: " + this.nom;
	}
	
	
}
