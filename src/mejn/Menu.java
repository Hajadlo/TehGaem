package mejn;

import creature.Kreatura;
import characters.*;
import predmety.*;

public class Menu {

	public static void main(String[] args) {
		
		Postava typek = new Rytir("Konan");
		Postava magic = new Kouzelnik("Mrakoplas");
		
		Kreatura kentaur = new Kreatura("vórèíf", 10, 15);
		
		typek.boj(kentaur);
		magic.boj(kentaur);
		
		typek.boj(magic);
		magic.boj(typek);
		
		Predmet hulka = new Hul("Hulka cool veci");
		Predmet kape = new Kape("Kape cool veci");
		
		Predmet mecak = new Mec("Frostfang");
		Predmet krouzkovka = new Platovka("Nevim");
		
		magic.getPredmet(hulka);
		magic.getPredmet(kape);
		
		typek.getPredmet(mecak);
		typek.getPredmet(krouzkovka);

		typek.boj(magic);
		typek.boj(magic);
		typek.doleceni(3);
		
		System.out.println(magic.info());
		System.out.println(typek.info());
	}
}