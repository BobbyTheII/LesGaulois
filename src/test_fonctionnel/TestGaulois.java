package test_fonctionnel;

import personnages.*;

public class TestGaulois {
	//main A
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",5);
		Druide panoramix = new Druide("Panoramix",2);
		Soldat minus = new Soldat("Minus",6,Grade.SOLDAT);
		Gaulois agecanonix = new Gaulois("Agecanonix",1);
		Gaulois assurancetourix = new Gaulois("Assurancetourix",2);
		Gaulois obelix = new Gaulois("Obélix",15);
		Gaulois abraracourcix = new Gaulois("Abraracourcix",5);

		minus.equiperArmure(Equipement.BOUCLIER);
		minus.equiperArmure(Equipement.CASQUE);
		minus.equiperArmure(Equipement.PLASTRON);
		
		panoramix.fabriquerPotions(3);
		panoramix.boosterGaulois(asterix);
		panoramix.boosterGaulois(obelix);
		panoramix.boosterGaulois(assurancetourix);
		panoramix.boosterGaulois(abraracourcix);
		panoramix.boosterGaulois(agecanonix);
		
		asterix.parler("Bonjour à tous");
		minus.parler("UN GAU… UN GAUGAU…");
		while(!(asterix.estATerre()) && !(minus.estATerre())){
			asterix.frapper(minus);
			minus.frapper(asterix);
		}
	}

}
