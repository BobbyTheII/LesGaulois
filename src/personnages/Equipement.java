package personnages;

public enum Equipement {
	CASQUE("Le casque absorbe 2 du coup ",2),PLASTRON("Le plastron absorbe 3 du coup ",3),BOUCLIER("Le bouclier absorbe 3 du coup ",3);
	
	private String chaine;
	private int forceDeduite;
	
	private Equipement(String chaine,int forceDetruite) {
		this.chaine = chaine;
		this.forceDeduite = forceDetruite;
	}
	
	public int getDefense() {
		return forceDeduite;
	}
	
	@Override
	public String toString() {
		return chaine;
	}
}
