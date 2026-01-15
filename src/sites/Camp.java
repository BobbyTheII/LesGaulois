package sites;

import personnages.Soldat;
import personnages.Grade;

public class Camp {
	private Soldat commendant;
	private Soldat[] soldats = new Soldat[80];
	private int indice = 0;
	
	public Camp(Soldat commendant) {
		if(commendant.getGrade()==Grade.CENTURION) {
			this.commendant = commendant;
		}
		else {
			System.out.println("le soldat n'est pas assez haut gradé");
		}
	}
	
	public Soldat getCommendant() {
		return commendant;
	}
	
	public void ajouterSoldat(Soldat soldat) {
		if(indice==soldats.length) {
			commendant.parler("Désolé Ballondebaudrus notre camp est complet !");
		}
		else {
			soldats[indice]=soldat;
			indice++;
			soldat.parler("Je mets mon épée au service de Rome dans le camp dirigé par "+commendant.getNom());
		}
	}
	
	public void afficherCamp() {
		System.out.println("Le camp dirigé par "+commendant.getNom()+" contient les soldats :");
		for(int i =0;i<indice;i++) {
			System.out.println("- "+soldats[i].getNom());
		}
	}
	
	public void changerCommandant(Soldat soldat) {
		if (soldat.getGrade()==Grade.CENTURION) {
			commendant = soldat;
			soldat.parler("Moi "+soldat.getNom()+" je prends la direction du camp romain. ");
		}
		else {
			soldat.parler(" Je ne suis pas suffisamment gradé pour prendre la direction du camp romain.");
		}
	}
}
