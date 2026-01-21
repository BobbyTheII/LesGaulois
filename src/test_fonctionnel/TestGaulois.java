package test_fonctionnel;

import personnages.*;

public class TestGaulois {
	//main A
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",5);
		
		Romain minus = new Romain("Minus",6);
		
		/*for(int i =0;i<2;i++) {
			minus.recevoirCoup(3);
		}*/
		Druide panoramix = new Druide("Panoramix",2);
		panoramix.fabriquerPotions(3);
		Gaulois agecanonix = new Gaulois("Agecanonix",1);
		Gaulois assurancetourix = new Gaulois("Assurancetourix",2);
		Gaulois obelix = new Gaulois("Obélix",15);
		Gaulois abraracourcix = new Gaulois("Abraracourcix",5);
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
