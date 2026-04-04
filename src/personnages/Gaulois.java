package personnages;

import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village; 

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void setVillage(Village village) {
		this.village=village;
		
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

		System.out.println(nom +" envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup(force*effetPotion /3);
		if(effetPotion>1) {
			effetPotion--;
		}
		
	}
	
	public void sePresenter() {
		if (village== null) {
			System.out.println(prendreParole()+"\"Bonjour,je m'appelle " + nom + ". Je voyage de villages en villages.\"");
		}else {
			if(this==village.getChef()) {
				System.out.println(prendreParole() + "\"Bonjour, je m'appelle " + nom + ". Je suis le chef du village : " + village.getNom() + ".\"");
			}else {
				System.out.println(prendreParole()+"\"Bonjour,je m'appelle " + nom + ". J'habite le village : "+ village.getNom()+".\"");
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
		
	}
	
	
	public void boirePotion(int forcePotion) {
		this.effetPotion=forcePotion;
	}
	
}

