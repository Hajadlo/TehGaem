package mejn;

import creature.Kreatura;
import characters.*;
import predmety.*;
import quest.Ukol;

public class Menu {

	public static void main(String[] args) {
		
		
		System.out.println(Postava.setPostava(0).boj(Kreatura.setKreatura()));
		System.out.println(Postava.setPostava(1).boj(Kreatura.setKreatura()));
		
		System.out.println(Postava.setPostava(0).boj(Postava.setPostava(1)));
		System.out.println(Postava.setPostava(1).boj(Postava.setPostava(0)));
		
		Postava.setPostava(0).getPredmet(Predmet.setPredmet());
		Postava.setPostava(0).getPredmet(Predmet.setPredmet());
		
		Postava.setPostava(1).getPredmet(Predmet.setPredmet());
		Postava.setPostava(1).getPredmet(Predmet.setPredmet());

		
		System.out.println(Postava.setPostava(0).boj(Postava.setPostava(1)));
		System.out.println(Postava.setPostava(1).boj(Postava.setPostava(0)));
		Postava.setPostava(0).doleceni(3);
		
		System.out.println(Postava.setPostava(0).info());
		System.out.println(Postava.setPostava(1).info());
		
		Postava.setPostava(0).levelUP();
		Postava.setPostava(1).levelUP();
		
		System.out.println(Postava.setPostava(0).aktivujQuest(Ukol.setUkol(), Kreatura.setKreatura()));
		System.out.println(Postava.setPostava(0).aktivujQuest(Ukol.setUkol(), Kreatura.setKreatura()));
		System.out.println(Postava.setPostava(1).aktivujQuest(Ukol.setUkol(), Kreatura.setKreatura()));
		System.out.println(Postava.setPostava(1).aktivujQuest(Ukol.setUkol(), Kreatura.setKreatura()));
		
		System.out.println(Postava.setPostava(0).info());
		
		System.out.println(Postava.setPostava(0).inventar());
	}
}