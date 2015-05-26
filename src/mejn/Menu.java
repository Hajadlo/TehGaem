package mejn;

import creature.Kreatura;
import characters.*;
import predmety.*;
import quest.Ukol;

public class Menu {

	public static void main(String[] args) {		
		
		
		Ukol prvni = new Ukol("Za horami", 5, 3);
		Ukol druhy = new Ukol("Blbustka", 8, 5);
		Ukol treti = new Ukol("Za horami", 15, 6);
		Ukol ctvrty = new Ukol("Za horami", 1, 1);
		Ukol paty= new Ukol("Za horami", 6, 4);
		Ukol sesty = new Ukol("Za horami", 3, 2);
		
		Ukol[] ukoly = {prvni, druhy, treti, ctvrty, paty, sesty};
		
		
		
		Postava typek = new Rytir("Konan");
		Postava magic = new Kouzelnik("Mrakoplas");
		
		Kreatura kentaur = new Kreatura("V�r��f", 15);
		Kreatura ogr = new Kreatura("Ogre", 25);
		Kreatura zaba = new Kreatura("Zabak Rabak", 10);
		
		
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

		
		magic.boj(typek);
		typek.boj(magic);
		typek.boj(magic);
		typek.doleceni(3);
		
		System.out.println(magic.info());
		System.out.println(typek.info());
		
		magic.levelUP();
		magic.levelUP();
		
		typek.aktivujQuest(prvni, kentaur);
		magic.aktivujQuest(druhy, zaba);
		magic.aktivujQuest(treti, ogr);
	}
}