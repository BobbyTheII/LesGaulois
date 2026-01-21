package personnages;

public class Soldat extends Romain{
	private Grade grade;
	private Equipement[] equipements = new Equipement[3];
	
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
		if(equipement == Equipement.CASQUE && equipements[0]==null) {
			equipements[0] = equipement;
			System.out.println(grade+this.donnerAuteur()+" s'équipe avec un casque.");
		}
		else if(equipement == Equipement.PLASTRON && equipements[1]==null) {
			equipements[1] = equipement;
			System.out.println(grade+this.donnerAuteur()+" s'équipe avec un plastron.");
		}
		else if(equipement == Equipement.BOUCLIER && equipements[2]==null) {
			equipements[2] = equipement;
			System.out.println(grade+this.donnerAuteur()+" s'équipe avec un bouclier.");
		}
		else {
			this.parler("J'ai trop d'affaires .");
		}
	}
	
	@Override
	public void recevoirCoup(int coup) {
		for(int i =0;i<3;i++) {
			if(equipements[i]!=null) {
				System.out.println(equipements[i]);
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
