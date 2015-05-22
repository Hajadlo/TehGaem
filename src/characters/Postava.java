package characters;

import java.util.ArrayList;

import quest.*;
import creature.Kreatura;
import predmety.*;

public abstract class Postava implements PostavaRozhrani{
	protected String jmeno;
	protected String povolani;
	
	protected int zivoty;
	protected int maxHP;
	protected int zlataky;
	public int level;
	protected int exp;
	protected int energie;
	
	protected float sila;
	protected float inteligence;
	protected float obrana;
	protected float utok;
	
	protected boolean aktivniQ;

	protected int id;
	
	protected ArrayList<Predmet> predmety = new ArrayList<Predmet>();
	
	protected Predmet slot1;
	protected Predmet slot2;
	
	public Postava(String jmeno){
		this.id +=1;
		this.jmeno = jmeno;
		this.maxHP = this.zivoty;
		this.zlataky = 20;
		this.level = 1;
		this.exp = 0;
		this.energie = 20;
	}
	
	public void boj(Postava nepritel) {
		System.out.println(this.jmeno + " utok: " + (this.utok/* + this.getUtok(zbran)*/));
		System.out.println("Obrane cislo " + nepritel.jmeno + " je: " + nepritel.obrana);
		if ((this.utok) > nepritel.obrana){
			this.zivoty -= 1;
			this.zlataky += 1;
			this.exp += 1;
			nepritel.zivoty -= 1;
			nepritel.zlataky -= 1;
			System.out.println("Porazil jsem " + nepritel.jmeno + "\n");
		}
		else{
			this.zivoty -=1;
			this.zlataky -=1;
			nepritel.zivoty -= 1;
			nepritel.zlataky += 1;
			System.out.println("Porazil mì " + nepritel.jmeno + "\n");
		}
	}
	
	
	public void boj(Kreatura nepritel) {
		System.out.println(this.jmeno + " utok: " + (this.utok));
		System.out.println("Obrane cislo " + nepritel.jmeno + " je: " + nepritel.obrana);
		if ((this.utok) > nepritel.obrana){
			this.zivoty -= 1;
			this.zlataky += 1;
			this.exp += 1;
			System.out.println("Porazil jsem " + nepritel.jmeno + "\n");
		}
		else{
			this.zivoty -=1;
			this.zlataky -=1;
			System.out.println("Porazil mì " + nepritel.jmeno + "\n");
		}
	}
	
	
	public int doleceni(int zlataky){
		System.out.println(this.jmeno + " by se chtel vylecit z " + this.zivoty + " zivotu");
		if (zlataky > this.zlataky){
			System.out.println(this.jmeno + " nema dost penez");
			return 0;
		}
		if ((this.zivoty + zlataky) > this.maxHP){
			System.out.println(this.jmeno + "presahuje svoje maximum zivotu");
			return 0;
		}
		System.out.println(this.jmeno + " byl dolecen o " + zlataky);
		this.zivoty += zlataky;
		return this.zivoty;
	}
	
	
	public String info(){
		return (this.povolani + " " + this.jmeno + "\nHP: " + this.zivoty + "\n"
				+ "Zlataky: " + this.zlataky + "\nLevel: " + this.level + "\n"
				+ "XP: " + this.exp +"\nEnergie: " + this.energie + "\n"
				+ "Sila: " + this.sila + "\nInteligence: " + this.inteligence + "\n"
				+ "Obrana: " + this.obrana + "\nUtok: " + this.utok + "\n");
	}
	
	
	public String getPredmet(Predmet predmet){
		if (predmet.vratCenu(predmet) > this.zlataky){
			return "Nemate dost zlata";
		}
		this.zlataky -= predmet.vratCenu(predmet);
		this.predmety.add(predmet);
		return "Uspesne jste koupil " + predmet.vratNazev(predmet);
	}
	
	public Predmet getslot1(){
		return slot1;
	}
	public Predmet getslot2(){
		return slot2;
	}
	
	public float getUtok(Zbran zbran){
		return zbran.setUtok(zbran);
	}
	
	
	public String aktivujQuest(Ukol ukol){
		if (ukol.vratEnergii(ukol) > this.energie){
			return (this.jmeno + " ma moc malo energie.");
		}
		this.aktivniQ = true;
		return (this.jmeno + " se vypravil na ukol a ziskal " + ukol.vratExpy(ukol));
	}
	
	
	public String levelUP(Postava postava){
		this.level += 1;
		this.exp = 0;
		return (this.jmeno + " dosahnul dost zkusenosti a je ted level " + this.level);
	}
}


