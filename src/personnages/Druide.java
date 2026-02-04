package personnages;

import java.util.Random;
import java.security.SecureRandom;

public class Druide extends Gaulois{
	private int nbPotions ;
	private int puissancePotions ;
	private Random random;
	
	public Druide(String nom,int force) {
		super(nom,force);
		try {
			 random = SecureRandom.getInstanceStrong();
		}catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	public String fabriquerPotions(int nbDose) {
		nbPotions = nbDose;
		puissancePotions = (random.nextInt(5))+2;
		return this.parler("J'ai concocté "+nbPotions+" doses de potion magique. Elle a une force de "+puissancePotions+"." )+"\n";
	}
	
	public String boosterGaulois(Gaulois gaulois) {
		String boost = "";
		if(gaulois.getNom().equals("Obélix")) {
			boost = this.parler(" Non, Obélix Non !... Et tu le sais très bien !")+"\n";
		}
		else if(nbPotions<1) {
			boost = this.parler(" Désolé "+gaulois.getNom()+" il n'y a plus une seule goutte de potion.")+"\n";
		}
		else {
			boost = this.parler("Tiens "+gaulois.getNom()+" un peu de potion magique.")+"\n";
			gaulois.boirePotion(puissancePotions);
			nbPotions--;
		}
		return boost;
	}
}
