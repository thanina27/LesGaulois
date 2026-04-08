package personnages;

import Objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement [] equipements = new Equipement[2] ;
	private int nbEquipement=0;
	private String texte;
	

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
	
	
//	public void recevoirCoup (int forceCoup) {
//		
//		assert isPreconditionVerified(forceCoup) : "la force du coup recu est négative !";
//		
//		int forceAvant = this.force;
//		force -= forceCoup;
//		
//		if (this.force < 1 ){
//			this.force = 0;
//			parler ("J'abandonne !");
//			
//		}else {
//			parler("Aïe");
//		}	
//	
//		assert isInvariantVeridied() : "la force est négative !";
//		assert isPostconditionVerified(forceAvant) : "la force n'a pas diminué";
//	}
	
	private void ajouterEquipement(Equipement equipement) {
		System.out.println("Le soldat "+ nom+ " s'équipe avec un " + equipement + ".");
        equipements[nbEquipement]=equipement;
        nbEquipement++;
	}
	
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
	    case 2 :
	        System.out.println("Le soldat " + nom + " est déja bien protégé !");
	        break;
	    case 1:
	        if (equipements[0]== equipement) {
	        	System.out.println("Le soldat " + nom + " possède déja un " + equipement + "!" );
	        }else {
	        	ajouterEquipement(equipement);
	        }
	        break;
	    default:
	    	ajouterEquipement(equipement);
	        break;
		}
	}
		
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculerResistanceEquipement(forceCoup);
		force -= forceCoup;
		switch (force) {
			case 0:
				parler("Aïe");  
			    break;
			default:
				 equipementEjecte = ejecterEquipement();
				 parler("J'abandonne..."); 
				 break;
			    
		}
		return equipementEjecte;
	}
		
	private int calculerResistanceEquipement(int forceCoup) {
	    texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
	    int resistanceEquipement = 0;
	    if (nbEquipement != 0) {
	        texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
	        for (int i = 0; i < nbEquipement;i++) {
	            if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) ) {
	                resistanceEquipement += 8;
	            } else {
	                //System.out.println("Equipement casque");
	                resistanceEquipement += 5;
	            }
	        }
	        texte += resistanceEquipement + "!";
	    }
	    parler(texte);
	    forceCoup -= resistanceEquipement;
	    if (forceCoup < 0) {
	        forceCoup = 0;  
	    }
	    return forceCoup;
	}
		
		
		
	private Equipement[] ejecterEquipement() {
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
			equipementEjecte[nbEquipementEjecte] = equipements[i];
			nbEquipementEjecte++;
			equipements[i] = null;
			}
		}
		return equipementEjecte;
		
	}
		
	public int getForce() {
	    return force;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		Romain minus = new Romain("Minus", 6);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
