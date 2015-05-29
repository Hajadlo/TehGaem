package characters;

import java.util.ArrayList;

import predmety.Nic;
import predmety.Predmet;
import quest.Ukol;
import creature.Kreatura;

public abstract class Postava implements PostavaRozhrani{
	protected String jmeno;
	protected String povolani;
	protected int zivoty;
	protected int maxHP;
	protected int zlataky;
	public int level;
	protected int exp;
	protected int energie;
	protected int maxEnergie;
	

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
		this.maxEnergie = 20;
		
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
			this.zivoty -= this.level;
			this.zlataky -= this.level;
			return ("Porazil me " + nepritel.jmeno + "\n");
	}
	
	
	public String doleceni(int zlataky){
		System.out.println(this.jmeno + " by se chtel vylecit z " + this.zivoty + " zivotu");
		if (zlataky > this.zlataky){
			return (this.jmeno + " nema dost penez");
		}
		if ((this.zivoty + zlataky) > this.maxHP){
			return(this.jmeno + " presahuje svoje maximum zivotu");
		}	
		this.zivoty += zlataky;
		return(this.jmeno + " byl dolecen o " + zlataky + " na " + (this.zivoty));
	}	
	
	
	public String odpocinek(int hodin){
		System.out.println(this.jmeno + " by si chtel odpocinout na " + hodin + " hodin");
		if (hodin*2+this.energie > this.maxEnergie){
			return (this.jmeno + " presahuje svoje maximum energie");
		}
		this.energie += hodin*2;
		return (this.jmeno + " odpocival " + hodin + " hodin a docerpal " + (hodin*2) + " energie.\n"
				+ "Aktualni energie: " + this.energie);
		
	}
	
	
	public String getPredmet(Predmet predmet){
		System.out.println(this.jmeno + " nasel " + predmet.vratNazev());
		if (predmet.vratSlot() == 1 && (this.povolani.equals(predmet.proPovolani) || predmet.proPovolani.equals("Oboje"))){
			slot1 = predmet;
			return (predmet.vratNazev() + " byl pridan jako zbran\n");
		}
		else if(predmet.vratSlot() == 2 && (this.povolani.equals(predmet.proPovolani) || predmet.proPovolani .equals("Oboje"))){
			slot2 = predmet;
			return (predmet.vratNazev() + " byl pridan jako brneni\n");
		}
		else{
			this.predmety.add(predmet);
			return ("Predmet " + predmet.vratNazev() + " nemuze pouzivat " + this.jmeno + ", a proto se ulozil do inventare\n");
		}
	}
	
	public void prodejItem(Predmet predmet){
		this.zlataky += (predmet.vratCenu())/2;
		System.out.println(this.jmeno + " prodal " + predmet.vratNazev() + " a ziskal " + (predmet.vratCenu()/2 + " zlatych\n"));
		predmety.remove(predmet);
	}

	
	public float[] statyPostavy(){  // 0 = sila, 1 = int, 2 = utok, 3 = obrana
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
		System.out.println(boj(nepritel));
		
		this.zlataky += this.level * ukol.odmena;
		this.exp += this.level * ukol.odmena;
		
		this.energie -= ukol.vratEnergii();
		System.out.println(getPredmet(Predmet.setPredmet()));
		return (this.jmeno + " se vypravil na ukol a ziskal " + (this.level * ukol.odmena) + " zkusenosti a ztratil " + ukol.vratEnergii() + " energie\n");
	}
	
	public String pracuj(int hodin){
		System.out.println(this.jmeno + " by si chtel pracovat " + hodin + " hodin");
		if (hodin > this.energie){
			return (this.jmeno + " nema dostatek energie na splneni prace");
		}
		this.zlataky += hodin*2;
		this.energie -= hodin;
		return (this.jmeno + " pracoval " + hodin + " hodiny, vydelal si " + (hodin*2) + " zlatych a ztratil " + hodin + " energie");
	}
		
	
	public void levelUP(){
		this.level += 1;
		this.exp = 0;
		System.out.println(this.jmeno + " dosahnul dost zkusenosti a je ted level " + this.level+"\n");
	}
	
	public float[] getStaty(Predmet predmet){
		float[] policko = predmet.vratStaty();
		return policko;
	}
	
	public Predmet bezSlot(){
		Predmet nic = new Nic("Zadny predmet");
		return nic;
	}
	
	public Predmet getSlot1(){
		return slot1;
	}


	public Predmet getSlot2(){
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
			itemky += i.vratNazev() + " ";
		}
		return ("V " + this.jmeno + " inventari se nachazi: " + itemky + "\n");
	}
}
