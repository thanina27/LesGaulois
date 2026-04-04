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
	
	public void recevoirCoup (int forceCoup) {
		
		force -= forceCoup;
		if (this.force < 1 ){
			this.force = 0;
			parler ("J'abandonne !");
			
		}else {
			parler("Aïe");
		}	
	
	assert isInvariantVeridied() : "la force est négative !";
	}
	
	
	public static void main(String[] args) {
		
		Romain minus = new Romain("Minus", 6);
	}
}
