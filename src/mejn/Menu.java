package mejn;

import java.util.Random;

import creature.Kreatura;
import characters.*;
import predmety.*;
import quest.Ukol;

public class Menu {
	
	public static Ukol getUkol(){
		
		Ukol prvni = new Ukol("Za horami", 5, 3);
		Ukol druhy = new Ukol("Blbustka", 8, 5);
		Ukol treti = new Ukol("Za horami", 15, 6);
		Ukol ctvrty = new Ukol("Za horami", 1, 1);
		Ukol paty= new Ukol("Za horami", 6, 4);
		Ukol sesty = new Ukol("Za horami", 3, 2);
		
		Ukol[] ukoly = {prvni, druhy, treti, ctvrty, paty, sesty};
		Ukol randomQ = (ukoly[new Random().nextInt(ukoly.length)]);
		return randomQ;
	}
	
	public static Kreatura getKreatura(){
		Kreatura kentaur = new Kreatura("V�r��f", 15);
		Kreatura ogr = new Kreatura("Ogre", 25);
		Kreatura zaba = new Kreatura("Zabak Rabak", 10);
		
		Kreatura[] kreaturky = {kentaur, ogr, zaba};
		Kreatura randomC = (kreaturky[new Random().nextInt(kreaturky.length)]);
		return randomC;
	}

	public static void main(String[] args) {
		
		
		
		Postava typek = new Rytir("Konan");
		Postava magic = new Kouzelnik("Mrakoplas");
		
		
		
		
		System.out.println(typek.boj(getKreatura()));
		System.out.println(magic.boj(getKreatura()));
		
		System.out.println(typek.boj(magic));
		System.out.println(magic.boj(typek));
		
		Predmet hulka = new Hul("Hulka cool veci");
		Predmet kape = new Kape("Kape cool veci");
		
		Predmet mecak = new Mec("Frostfang");
		Predmet krouzkovka = new Platovka("Nevim");
		
		
		
		magic.getPredmet(hulka);
		magic.getPredmet(kape);
		
		typek.getPredmet(mecak);
		typek.getPredmet(krouzkovka);

		
		System.out.println(magic.boj(typek));
		System.out.println(typek.boj(magic));
		System.out.println(typek.boj(magic));
		typek.doleceni(3);
		
		System.out.println(magic.info());
		System.out.println(typek.info());
		
		magic.levelUP();
		magic.levelUP();
		
		System.out.println(typek.aktivujQuest(getUkol(), getKreatura()));
		System.out.println(magic.aktivujQuest(getUkol(), getKreatura()));
		System.out.println(magic.aktivujQuest(getUkol(), getKreatura()));
		System.out.println(magic.aktivujQuest(getUkol(), getKreatura()));
		
		System.out.println(magic.info());
	}
}