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
	public String parler(String phrase) {
		return grade+this.donnerAuteur() + ": «"+phrase+"».";
	}
	
	public String equiperArmure(Equipement equipement) {
		boolean trouve = false;
		String equipe = "";
		for (int i = 0;i<indice && !trouve;i++) {
			if(equipements[i]==equipement) {
				trouve = true;
			}
		}
		if(!trouve && indice<equipements.length) {
			equipements[indice] = equipement;
			equipe= grade+ this.donnerAuteur()+ " s'équipe avec "+equipement;
			indice ++;
		}
		return equipe;
	}
	
	@Override
	public String recevoirCoup(int coup) {
		String coupRecu = "";
		for(int i =0;i<equipements.length;i++) {
			if(equipements[i]!=null) {
				coupRecu += equipements[i]+"absorbe "+equipements[i].getDefense()+" du coup \n";
				coup-=equipements[i].getDefense();
			}
		}
		if(coup>=0) {
			if((getForce()-coup)<=0) {
				setForce(0);
				coupRecu += this.parler("j'abandonne")+"\n";
			}
			else {
				setForce(getForce()-coup);
				coupRecu+=this.parler("AÏE !")+"\n";
			}
		}
		return coupRecu;
	}
	
}
