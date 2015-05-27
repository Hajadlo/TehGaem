package mejn;

import creature.Kreatura;
import characters.*;
import predmety.*;
import quest.Ukol;

public class Menu {

	public static void main(String[] args) {
		
		// PRODEJ ITEMU
		
		Postava typek = new Rytir("Konan");
		Postava magic = new Kouzelnik("Mrakoplas");
		
		System.out.println(typek.boj(Kreatura.setKreatura()));
		System.out.println(magic.boj(Kreatura.setKreatura()));
		
		System.out.println(typek.boj(magic));
		System.out.println(magic.boj(typek));
		
		System.out.println(magic.getPredmet(Predmet.setPredmet()));
		System.out.println(magic.getPredmet(Predmet.setPredmet()));
		
		System.out.println(typek.getPredmet(Predmet.setPredmet()));
		System.out.println(typek.getPredmet(Predmet.setPredmet()));

		
		System.out.println(magic.boj(typek));
		System.out.println(typek.boj(magic));
		typek.doleceni(3);
		
		System.out.println(magic.info());
		System.out.println(typek.info());
		
		magic.levelUP();
		typek.levelUP();
		
		System.out.println(typek.aktivujQuest(Ukol.setUkol(), Kreatura.setKreatura()));
		System.out.println(magic.aktivujQuest(Ukol.setUkol(), Kreatura.setKreatura()));
		
		System.out.println(magic.info());
		
		System.out.println(magic.inventar());
		
		System.out.println(magic.odpocinek(3));
	}
}
