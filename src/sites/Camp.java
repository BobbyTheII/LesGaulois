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
	
	public Soldat[] getSoldats() {
		return soldats;
	}
	
	public int getLength() {
		return indice;
	}
	
	public String ajouterSoldat(Soldat soldat) {
		String ajout = "";
		if(indice==soldats.length) {
			ajout += commendant.parler("Désolé Ballondebaudrus notre camp est complet !")+"\n";
		}
		else {
			soldats[indice]=soldat;
			indice++;
			ajout += soldat.parler("Je mets mon épée au service de Rome dans le camp dirigé par "+commendant.getNom())+"\n";
		}
		return ajout;
	}
	
	public void afficherCamp() {
		System.out.println("Le camp dirigé par "+commendant.getNom()+" contient les soldats :");
		for(int i =0;i<indice;i++) {
			System.out.println("- "+soldats[i].getNom());
		}
	}
	
	public String changerCommandant(Soldat soldat) {
		String nouveau = "";
		if (soldat.getGrade()==Grade.CENTURION) {
			commendant = soldat;
			nouveau += soldat.parler("Moi "+soldat.getNom()+" je prends la direction du camp romain. ")+"\n";
		}
		else {
			nouveau += soldat.parler(" Je ne suis pas suffisamment gradé pour prendre la direction du camp romain.")+"\n";
		}
		return nouveau;
	}
}
