package mejn;

import java.util.*;

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
		
		//Predmet hulka = new Predmet("Hulka cool veci", 12);
		
		//magic.getPredmet(hulka);
		
		typek.boj(magic);
		typek.boj(magic);
		typek.boj(magic);
		typek.doleceni(3);
		
		System.out.println(magic.info());
		System.out.println(typek.info());
	}
}