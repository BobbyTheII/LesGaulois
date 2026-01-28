package batailles;

public class Conteur {
	
	private String nom;
	
	public Conteur(String nom) {
		this.nom = nom;
	}
	
	public void conterHistoire(IBataille bataille) {
		System.out.println("Je suis "+nom+". Je vais vous conter une histoire qui se déroule en 50 avant Jésus-Christ,\r\n"
				+ "du temps où la Gaule est occupée par les Romains.\n");
		String histoire ;
		histoire = bataille.decrireContexte() +"\n"+
				bataille.choisirCombattant()+"\n"+
				bataille.preparerCombat()+ "\n"+
				bataille.decrireCombat()+ "\n"+
				bataille.donnerResultat();
		System.out.println(histoire);
	}
}
