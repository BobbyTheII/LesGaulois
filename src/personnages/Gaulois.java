package personnages;

public class Gaulois extends Personnage{
	private float forceAdditionel = 1;
	
	public Gaulois(String nom,int force) {
		super(nom,force);
	}
	
	@Override
	protected String donnerAuteur() {
		return "gaulois "+this.getNom();
	}
	
	public void boirePotion(int puissancePotions) {
		forceAdditionel = puissancePotions;
	}
	 @Override
	public void frapper(Personnage adversaire) {
		 if(this.getForce()>0) {
		int nouvelleForce = (int)(this.getForce()*forceAdditionel);
		System.out.println("Le "+this.donnerAuteur()+" donne un grand coup de force "+nouvelleForce/3+" au "+adversaire.donnerAuteur());
		adversaire.recevoirCoup((int)(nouvelleForce/3));
		if(forceAdditionel>1.) {
			forceAdditionel-=0.5;
		}
		}
	}
	
	//main C
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8);
		System.out.println(asterix.getNom());
	}
	
}
