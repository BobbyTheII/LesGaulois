package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom,int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String phrase) {
		System.out.println("Le romain "+nom+" : «"+phrase+"».");
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
