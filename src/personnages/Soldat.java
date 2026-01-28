package personnages;

public class Soldat extends Romain{
	private Grade grade;
	private Equipement[] equipements = new Equipement[3];
	private int indice = 0;
	
	public Soldat(String nom,int force,Grade grade) {
		super(nom,force);
		this.grade = grade;
	}
	
	public Grade getGrade() {
		return grade;
	}
	
	@Override
	public void parler(String phrase) {
		System.out.println(grade+this.donnerAuteur() + ": «"+phrase+"».");
	}
	
	public void equiperArmure(Equipement equipement) {
		boolean trouve = false;
		for (int i = 0;i<indice && !trouve;i++) {
			if(equipements[i]==equipement) {
				trouve = true;
			}
		}
		if(!trouve && indice<equipements.length) {
			equipements[indice] = equipement;
			System.out.println(grade+ this.donnerAuteur()+ " s'équipe avec "+equipement);
			indice ++;
		}
	}
	
	@Override
	public void recevoirCoup(int coup) {
		for(int i =0;i<equipements.length;i++) {
			if(equipements[i]!=null) {
				System.out.println(equipements[i]+"absorbe "+equipements[i].getDefense()+" du coup ");
				coup-=equipements[i].getDefense();
			}
		}
		if(coup>=0) {
			if((getForce()-coup)<=0) {
				setForce(0);
				this.parler("j'abandonne");
			}
			else {
				setForce(getForce()-coup);
				this.parler("AÏE !");
			}
		}
	}
	
}
