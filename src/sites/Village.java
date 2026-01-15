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
	
	public void ajouterVillageois(Gaulois gauloi) {
		if(indice==gaulois.length) {
			chef.parler("Désolé "+gauloi.getNom()+" mon village est déjà bien rempli. ");
		}
		else {
			gaulois[indice]=gauloi;
			indice++;
			chef.parler(" Bienvenue "+gauloi.getNom()+" !");
		}
	}
	
	public void afficherVillage() {
		System.out.println("Le Village de "+chef.getNom()+" est habité par :");
		for(int i =0;i<indice;i++) {
			System.out.println("- "+gaulois[i].getNom());
		}
	}
	
	public void changerChef(Gaulois nouveauChef) {
		chef.parler("Je laisse mon grand bouclier au grand "+nouveauChef.getNom());
		chef = nouveauChef;
		chef.parler(" Merci !");
	}
}
