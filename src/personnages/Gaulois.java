package personnages;

public class Gaulois {
	private String nom;
	private int force;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");

	}

	private String prendreParole() {
		return "Le Gaulois " + nom + ":";
	}
	
	
	@Override
	public String toString() {
		return  nom;
	}
	
	public void frapper (Romain romain) {
		//String nomRomain= romain.getNom(); nomRomain
		//est utilisé uniquement dans l’affichage : la variable n’est pas utile,

		System.out.println(nom +" envoie un grand coup dans la machoire de " + romain.getNom());
		//int forceCoup= this.force / 3;forceCoup est utilisé
		//uniquement dans l’appel à la méthode recevoirCoup : la variable n’est pas utile.

		romain.recevoirCoup(force /3);
		
	}
	
	public static void main(String[] args) {
		
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
		
	}
	
	
}

