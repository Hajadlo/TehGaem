package characters;

import java.util.ArrayList;

import quest.*;
import creature.Kreatura;
import predmety.*;

public abstract class Postava implements PostavaRozhrani{
	protected String jmeno;
	protected String povolani;
			//Zitra vyresit randomovani questu a inventar
	protected int zivoty;
	protected int maxHP;
	protected int zlataky;
	public int level;
	protected int exp;
	protected int energie;
	

	protected float sila;
	protected float baseSila;
	protected float inteligence;
	protected float baseInt;
	protected float utok;
	protected float obrana;
	

	
	protected ArrayList<Predmet> predmety = new ArrayList<Predmet>();
	
	protected Predmet slot1;
	protected Predmet slot2;
	
	float[] policko = new float[4];
	float[] poleStatu = new float[4];
	
	public Postava(String jmeno){
		this.jmeno = jmeno;
		this.zlataky = 20;
		this.level = 1;
		this.exp = 0;
		this.energie = 20;
		
		slot1 = this.bezSlot();
		slot2 = this.bezSlot();
	}
	
	
	public String boj(Postava nepritel) {
		System.out.println(this.jmeno + " utok: " + (this.statyPostavy()[2]));
		System.out.println("Obrane cislo " + nepritel.jmeno + " je: " + nepritel.statyPostavy()[3]);
		
		if ((this.statyPostavy()[2]) > nepritel.statyPostavy()[3]){
			if (nepritel.level > this.level){
				this.zivoty -= this.level;
				this.zlataky += nepritel.level;
				this.exp += nepritel.level;
				nepritel.zivoty -= this.level;
			}
			
			else {
				this.zivoty -= this.level;
				this.exp += this.level;
				nepritel.zivoty -= nepritel.level;
			}
			
			return ("Porazil jsem " + nepritel.jmeno + "\n");
		}
		
		
		else{
			
			if (nepritel.level > this.level){
				this.zivoty -= this.level;
				this.zlataky -= this.level;
				nepritel.zivoty -= nepritel.level;
				nepritel.zlataky += this.level;
			}
			
			else{
				this.zivoty -= nepritel.level;
				this.zlataky -= nepritel.level;
				nepritel.zivoty -= nepritel.level;
				nepritel.zlataky += this.level;
			}
			
			return ("Porazil mì " + nepritel.jmeno + "\n");
		}
	}
	
	
	public String boj(Kreatura nepritel) {
		System.out.println(this.jmeno + " utok: " + (this.statyPostavy()[2]));
		System.out.println("Obrane cislo " + nepritel.jmeno + " je: " + nepritel.obrana);
		if ((this.statyPostavy()[2]) > nepritel.obrana){
			this.zivoty -= this.level;
			this.zlataky += this.level;
			this.exp += this.level;
			return("Porazil jsem " + nepritel.jmeno + "\n");
		}
		else{
			this.zivoty -= this.level;
			this.zlataky -= this.level;
			return ("Porazil mì " + nepritel.jmeno + "\n");
		}
	}
	
	
	public int doleceni(int zlataky){
		System.out.println(this.jmeno + " by se chtel vylecit z " + this.zivoty + " zivotu");
		if (zlataky > this.zlataky){
			System.out.println(this.jmeno + " nema dost penez");
			return 0;
		}
		if ((this.zivoty + zlataky) > this.maxHP){
			System.out.println(this.jmeno + " presahuje svoje maximum zivotu");
			return 0;
		}	
		this.zivoty += zlataky;
		System.out.println(this.jmeno + " byl dolecen o " + zlataky + " na " + (this.zivoty));
		return this.zivoty;
	}	
	
	public void getPredmet(Predmet predmet){
		if (predmet.vratSlot() == 1 && (this.povolani == predmet.proPovolani || predmet.proPovolani == "Oboje")){
			slot1 = predmet;
			System.out.println(predmet.vratNazev() + " byl pridan jako zbran");
		}
		else if(predmet.vratSlot() == 2 && (this.povolani == predmet.proPovolani || predmet.proPovolani == "Oboje")){
			slot2 = predmet;
			System.out.println(predmet.vratNazev() + " byl pridan jako brneni");
		}
		else{
			this.predmety.add(predmet);
			System.out.println("Predmet " + predmet.vratNazev() + " nejde pouzivat " + this.jmeno + " a proto se ulozil do inventare");
		}
		System.out.println(this.jmeno + " nasel " + predmet.vratNazev() + "\n");
	}
	

	
	public float[] statyPostavy(){
		this.sila = this.getStaty(slot1)[3] + this.getStaty(slot2)[3] + this.baseSila;
		this.inteligence = this.getStaty(slot1)[2] + this.getStaty(slot2)[2] + this.baseInt;
		if (this.povolani == "Kouzelnik"){
			this.utok = this.getStaty(slot1)[0] + this.inteligence;
		}
		else{
			this.utok = this.getStaty(slot1)[0] + this.sila;
		}
		this.obrana = this.getStaty(slot2)[1];
		float[] poleStatu = {this.sila, this.inteligence, this.utok, this.obrana, this.zivoty};
		return poleStatu;
		
	}
	
	public String aktivujQuest(Ukol ukol, Kreatura nepritel){
		System.out.println(this.jmeno + " se vydal na ukol: " + ukol.nazev);
		System.out.println(this.jmeno + " narazil na " + nepritel.jmeno);
		if (ukol.vratEnergii() >= this.energie){
			return (this.jmeno + " ma moc malo energie.\n");
		}
		boj(nepritel);
		
		this.zlataky += this.level * ukol.odmena;
		this.exp += this.level * ukol.odmena;
		
		this.energie -= ukol.vratEnergii();		
		return (this.jmeno + " se vypravil na ukol a ziskal " + (this.level * ukol.odmena) + " zkusenosti a ztratil " + ukol.vratEnergii() + " energie\n");
	}
	
	
	public void levelUP(){
		this.level += 1;
		this.exp = 0;
		System.out.println(this.jmeno + " dosahnul dost zkusenosti a je ted level " + this.level);
	}
	
	public float[] getStaty(Predmet predmet){
		float[] policko = predmet.vratStaty();
		return policko;
	}
	
	public Predmet bezSlot(){
		Predmet nic = new Nic("NIC!");
		return nic;
	}
	
	public Predmet getslot1(){
		return slot1;
	}


	public Predmet getslot2(){
		return slot2;
	}
	
	public String info(){
		return ("\n" + this.povolani + " " + this.jmeno + "\nHP: " + this.zivoty + "\nZlataky: "
				+ this.zlataky + "\nLevel: " + this.level + "\n" + "XP: " + this.exp +"\nEnergie: "
				+ this.energie + "\n" + "Sila: " + this.statyPostavy()[0] + "\nInteligence: " + this.statyPostavy()[1]
				+ "\n" + "Utok: " + this.statyPostavy()[2] + "\nObrana: " + this.statyPostavy()[3] + "\nPredmety: " 
				+ slot1.vratNazev() + ", " + slot2.vratNazev()) +"\n";
	}
	
	public String inventar(){
		String itemky = "";
		for (Predmet i : predmety){
			itemky += i + ", ";
		}
		return itemky;
	}
}

