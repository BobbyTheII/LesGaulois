package batailles;

import personnages.*;
import sites.*;
import java.util.Random;

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
		String preparation = "Les soldats s'etaient bien préparé :\n";
		for(int i = 0;i<soldats.length;i++) {
			preparation += "-"+ soldats[i].equiperArmure(Equipement.CASQUE)+"\n";
			preparation += "-"+ soldats[i].equiperArmure(Equipement.PLASTRON)+"\n";
			preparation += "-"+ soldats[i].equiperArmure(Equipement.BOUCLIER)+"\n";
		}
		return preparation;
	}
	
	private boolean sontATerreG() {
		boolean ko = true;
		for(int i = 0;i<promeneurs.length;i++) {
			if(!promeneurs[i].estATerre()) {
				ko = false;
			}
		}
		return ko;
	}
	
	private boolean sontATerreS() {
		boolean ko = true;
		for(int i = 0;i<soldats.length;i++) {
			if(!soldats[i].estATerre()) {
				ko = false;
			}
		}
		return ko;
	}
	
	private int getIndiceG() {
		int indice = -1;
		for(int i = 0; i<promeneurs.length;i++) {
			if(!promeneurs[i].estATerre()) {
				indice = i;
			}
		}
		return indice;
	}
	
	private int getIndiceS() {
		int indice = -1;
		for(int i = 0; i<soldats.length;i++) {
			if(!soldats[i].estATerre()) {
				indice = i;
			}
		}
		return indice;
	}

	@Override
	public String decrireCombat() {
		String decrit = "";
		boolean gauloisKO = false;
		boolean soldatsKO = false;
		int indiceG;
		int indiceS;
		Random random = new Random();
		while(!soldatsKO && !gauloisKO) {
			Gaulois frappeurG = promeneurs[random.nextInt(promeneurs.length)];
			Soldat frappeurS = soldats[random.nextInt(soldats.length)];
			Gaulois victimeG = promeneurs[random.nextInt(promeneurs.length)];
			Soldat victimeS = soldats[random.nextInt(soldats.length)];	
			indiceG = getIndiceG();
			indiceS = getIndiceS();
			if(frappeurG.estATerre()) {	
				frappeurG = promeneurs[indiceG];
			}
			if(frappeurS.estATerre()) {
				frappeurS = soldats[indiceS];
			}
			if(victimeG.estATerre()) {
				victimeG = promeneurs[indiceG];
			}
			if(victimeS.estATerre()) {
				victimeS = soldats[indiceS];
			}

			decrit+= frappeurG.frapper(victimeS)+"\n";
			decrit+= frappeurS.frapper(victimeG)+"\n";
			soldatsKO = sontATerreS();
			gauloisKO = sontATerreG();
		}
		return decrit;
	}

	@Override
	public String donnerResultat() {
		// TODO Auto-generated method stub
		return "donnerResultat";
	}

}
