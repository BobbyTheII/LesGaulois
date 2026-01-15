package personnages;

public abstract class Personnage {
	private String nom;
	private int force;
	
	protected Personnage(String nom,int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String phrase) {
		System.out.println("Le "+this.donnerAuteur() + ": «"+phrase+"».");
	}
	
	protected abstract String donnerAuteur();
	
	public void frapper(Personnage adversaire) {
		System.out.println("Le "+this.donnerAuteur()+" donne un grand coup au "+adversaire.donnerAuteur());
		adversaire.recevoirCoup((int)force/3);
	}
	
	public void recevoirCoup(int coup) {
		if((force-coup)<=0) {
			force = coup;
			this.parler("j'abandonne");
		}
		else {
			force -= coup;
			this.parler("AÏE !");
		}
	}
}
