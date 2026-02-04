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
	public String frapper(Personnage adversaire) {
		 String frappe = "";
		 if((this.getForce()>0)&&(adversaire.getForce()>0)) {
			int nouvelleForce = (int)(this.getForce()*forceAdditionel);
			frappe = "Le "+this.donnerAuteur()+" donne un grand coup de force "+nouvelleForce+" au "+adversaire.donnerAuteur()+"\n";
			frappe += adversaire.recevoirCoup(nouvelleForce);
			if(forceAdditionel>1.) {
				forceAdditionel-=0.5;
			}
		}
		return frappe;
	}
	
	//main C
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8);
		System.out.println(asterix.getNom());
	}
	
}
