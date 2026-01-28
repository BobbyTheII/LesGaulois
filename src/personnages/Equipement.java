package personnages;

public enum Equipement {
	CASQUE("Le casque ",2),PLASTRON("Le plastron ",3),BOUCLIER("Le bouclier ",3);
	
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
