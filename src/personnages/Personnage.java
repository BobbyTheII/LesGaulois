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
	
	public int getForce() {
		return force;
	}
	
	public void setForce(int force) {
		this.force = force;
	}
	
	public void parler(String phrase) {
		System.out.println("Le "+this.donnerAuteur() + ": «"+phrase+"».");
	}
	
	protected abstract String donnerAuteur();
	
	public void frapper(Personnage adversaire) {
		if(force!=0) {
			System.out.println("Le "+this.donnerAuteur()+" donne un grand coup de force "+(int)force/3+" au "+adversaire.donnerAuteur());
			adversaire.recevoirCoup((int)force/3);
		}
	}
	
	public void recevoirCoup(int coup) {
		if((force-coup)<=0) {
			force = 0;
			this.parler("j'abandonne");
		}
		else {
			force -= coup;
			this.parler("AÏE !");
		}
	}
	
	public boolean estATerre() {
		return force == 0;
	}
}
