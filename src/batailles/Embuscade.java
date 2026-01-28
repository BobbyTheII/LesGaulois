package batailles;

import personnages.*;
import sites.*;

public class Embuscade implements IBataille{
	
	private Village village;
	private Camp camp;
	private Gaulois[] promeneurs = new Gaulois[4];
	private Soldat[] soldats = new Soldat[2];
	
	public Embuscade(Village village,Camp camp) {
		this.village = village;
		this.camp = camp;
	}
	
	private String selectionnerPromeneurs() {
		String phrase = "Il s'agit de ";
		Gaulois[] gaulois = village.getVillageois();
		int indice = village.getLength();
		for(int i = 0;i<promeneurs.length-1;i++) {
			promeneurs[i] = gaulois[indice-1-i];
			phrase+=promeneurs[i].getNom();
			if(i<promeneurs.length-2) {
				phrase+=", ";
			}
		}
		promeneurs[promeneurs.length-1] = gaulois[indice-promeneurs.length];
		phrase+=" et "+promeneurs[promeneurs.length-1].getNom()+".\n";
		return phrase;
	}
	
	private String selectionnerSoldat() {
		String phrase = "Mais cachés derrière des bosquets se cachent ";
		Soldat[] romains = camp.getSoldats();
		int indice = camp.getLength();
		for(int i = 0;i<soldats.length -1;i++) {
			if(romains[indice-1-i].getGrade() == Grade.SOLDAT) {
				soldats[i] = romains[indice-1-i];
				phrase+=soldats[i].getNom();
				if(indice<soldats.length-2) {
					phrase+=", ";
				}
			}
		}
		if(romains[indice-soldats.length].getGrade() == Grade.SOLDAT) {
			soldats[soldats.length-1] = romains[indice-soldats.length];
			phrase+=" et "+soldats[soldats.length-1].getNom()+".\n";
		}
		return phrase;
	}

	@Override
	public String decrireContexte() {
		return "Dans une sombre forêt dans un coin reculé de la Gaule,"
				+ " quatre comparses se promènent.";
	}

	@Override
	public String choisirCombattant() {
		return selectionnerPromeneurs() + selectionnerSoldat();
	}

	@Override
	public String preparerCombat() {
		// TODO Auto-generated method stub
		return "preparerCombat";
	}

	@Override
	public String decrireCombat() {
		// TODO Auto-generated method stub
		return "decrireCombat";
	}

	@Override
	public String donnerResultat() {
		// TODO Auto-generated method stub
		return "donnerResultat";
	}

}
