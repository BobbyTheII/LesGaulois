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
	
	public void fabriquerPotions(int nbDose) {
		nbPotions = nbDose;
		puissancePotions = (random.nextInt(5))+2;
		this.parler("J'ai concocté "+nbPotions+" doses de potion magique. Elle a une force de "+puissancePotions+"." );
	}
	
	public void boosterGaulois(Gaulois gaulois) {
		if(gaulois.getNom().equals("Obélix")) {
			this.parler(" Non, Obélix Non !... Et tu le sais très bien !");
		}
		else if(nbPotions<1) {
			this.parler(" Désolé "+gaulois.getNom()+" il n'y a plus une seule goutte de potion.");
		}
		else {
			this.parler("Tiens "+gaulois.getNom()+" un peu de potion magique.");
			gaulois.boirePotion(puissancePotions);
			nbPotions--;
		}
	}
}
