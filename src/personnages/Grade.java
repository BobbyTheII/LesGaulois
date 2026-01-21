package personnages;

public enum Grade {
	SOLDAT("Le soldat "),TESSERARIUS("Le tesserarius "),OPTIO("L'optio "),CENTURION("Le centurion ");
	
	private String chaine;
	
	private Grade(String chaine) {
		this.chaine = chaine;
		}
	@Override
	public String toString() {
		return chaine;
	}
}
