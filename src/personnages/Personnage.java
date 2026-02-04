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
	
	public String parler(String phrase) {
		return "Le "+this.donnerAuteur() + ": «"+phrase+"».";
	}
	
	protected abstract String donnerAuteur();
	
	public String frapper(Personnage adversaire) {
		String frappe = "";
		if((force!=0)&&(adversaire.getForce()!=0)) {
			frappe ="Le "+this.donnerAuteur()+" donne un grand coup de force "+force+" au "+adversaire.donnerAuteur()+"\n";
			frappe += adversaire.recevoirCoup(force)+"\n";
		}
		return frappe;
	}
	
	public String recevoirCoup(int coup) {
		String coupRecu = "";
		if((force-coup)<=0) {
			force = 0;
			coupRecu = this.parler("j'abandonne...")+"\n";
		}
		else {
			force -= coup;
			coupRecu = this.parler("AÏE !")+"\n";
		}
		return coupRecu;
	}
	
	public boolean estATerre() {
		return force == 0;
	}
}
