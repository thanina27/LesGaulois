package personnages;

import Objets.Equipement;
import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private Village village; 
	private int force;
	private int nbTrophees;
	private Equipement [] trophees= new Equipement[100];

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

//	private String prendreParole() {
//		return "Le Gaulois " + nom + ":";
//	}
	
	
	//METHODE AJOUTEE POUR TP3
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	
//	public String toString() {
//		return  nom;
//	}
	
//	public void frapper (Romain romain) {
//
//		System.out.println(nom +" envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup(force*effetPotion /3);
//		if(effetPotion>1) {
//			effetPotion--;
//		}
//		
//	}
	
	
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement [] tropheesDuRomain = romain.recevoirCoup((force / 3) * effetPotion);
		effetPotion--;
		if (effetPotion < 1) {
			effetPotion = 1;
		}
		for (int i = 0; tropheesDuRomain != null && i < tropheesDuRomain.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesDuRomain[i];
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

