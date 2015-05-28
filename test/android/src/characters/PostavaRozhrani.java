package characters;

import predmety.Predmet;
import quest.Ukol;
import creature.Kreatura;

public interface PostavaRozhrani{
	
	
	String boj(Postava nepritel);
	String boj(Kreatura nepritel);
	String doleceni(int zlataky);
	String odpocinek(int hodin);
	String getPredmet(Predmet predmet);
	float[] statyPostavy();
	String aktivujQuest(Ukol ukol, Kreatura nepritel);
	void levelUP();
	float[] getStaty(Predmet predmet);
	Predmet bezSlot();
	Predmet getSlot1();
	Predmet getSlot2();
	String info();
	String inventar();
}