package tn.uma.isamm;

public class Etudiant {
	
	private String cin;
	private String nom;
    private float moyenne;
    private String motDePasse;
    
    
    public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Etudiant(String cin, String nom, float moyenne, String motDePasse) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.moyenne = moyenne;
		this.motDePasse = motDePasse;
	}

	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(float moyenne) {
		this.moyenne = moyenne;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	

}
