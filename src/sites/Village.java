package sites;

import personnages.Gaulois;

public class Village {
	private Gaulois chef;
	private Gaulois[] gaulois = new Gaulois[50];
	private int indice = 0;
	
	public Village(Gaulois chef) {
		this.chef = chef;
	}
	
	public Gaulois getChef() {
		return chef;
	}
	
	public Gaulois[] getVillageois() {
		return gaulois;
	}
	
	public int getLength() {
		return indice;
	}
	
	public String ajouterVillageois(Gaulois gauloi) {
		String ajout = "";
		if(indice==gaulois.length) {
			ajout += chef.parler("Désolé "+gauloi.getNom()+" mon village est déjà bien rempli. ")+"\n";
		}
		else {
			gaulois[indice]=gauloi;
			indice++;
			ajout += chef.parler(" Bienvenue "+gauloi.getNom()+" !")+"\n";
		}
		return ajout;
	}
	
	public void afficherVillage() {
		System.out.println("Le Village de "+chef.getNom()+" est habité par :");
		for(int i =0;i<indice;i++) {
			System.out.println("- "+gaulois[i].getNom());
		}
	}
	
	public String changerChef(Gaulois nouveauChef) {
		String nouveau = "";
		nouveau += chef.parler("Je laisse mon grand bouclier au grand "+nouveauChef.getNom())+"\n";
		chef = nouveauChef;
		nouveau += chef.parler(" Merci !")+"\n";
		return nouveau;
	}

}
