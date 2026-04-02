package Objets;

public class Chaudron {
	
	private int quantitePotion;
	private int forcePotion;
	
	
	public Chaudron(int quantitePotion, int forcePotion) {
		this.quantitePotion = quantitePotion;
		this.forcePotion = forcePotion;
		
	}
	
	
	public boolean resterPotion() {
		return this.quantitePotion>0 ;
	}
	
	
	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}
		
	public int prendreLouche() {
		quantitePotion--;
		if (quantitePotion==0) {
			this.forcePotion=0;
		}
		return forcePotion;
	}
				
	
	
}
