package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVeridied() : "la force est négative !";
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Romain " + nom +":";
	}
	
	private boolean isInvariantVeridied() {
		return this.force>=0;
	}
	
	private boolean isPreconditionVerified(int forceCoup) {
		return forceCoup >=0;
	}
	
	private boolean isPostconditionVerified(int forceAvant) {
		return forceAvant > force;
	}
	
	
	public void recevoirCoup (int forceCoup) {
		
		assert isPreconditionVerified(forceCoup) : "la force du coup recu est négative !";
		
		int forceAvant = this.force;
		force -= forceCoup;
		
		if (this.force < 1 ){
			this.force = 0;
			parler ("J'abandonne !");
			
		}else {
			parler("Aïe");
		}	
	
	assert isInvariantVeridied() : "la force est négative !";
	assert isPostconditionVerified(forceAvant) : "la force n'a pas diminué";
	}
	
	
	public static void main(String[] args) {
		
		Romain minus = new Romain("Minus", 6);
	}
}
