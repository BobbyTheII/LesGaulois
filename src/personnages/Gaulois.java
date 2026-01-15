package personnages;

public class Gaulois extends Personnage{
	
	public Gaulois(String nom,int force) {
		super(nom,force);
	}
	
	@Override
	protected String donnerAuteur() {
		return "gaulois "+this.getNom();
	}
	
	//main C
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8);
		System.out.println(asterix.getNom());
	}
	
}
