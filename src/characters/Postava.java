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
	protected float baseSila;
	protected float inteligence;
	protected float baseInt;
	protected float utok;
	protected float obrana;
	
	protected boolean aktivniQ;

	protected int id;
	
	protected ArrayList<Predmet> predmety = new ArrayList<Predmet>();
	
	protected Predmet slot1;
	protected Predmet slot2;
	
	float[] policko = new float[4];
	float[] poleStatu = new float[4];
	
	public Postava(String jmeno){
		this.id +=1;
		this.jmeno = jmeno;
		this.zlataky = 20;
		this.level = 1;
		this.exp = 0;
		this.energie = 20;
		
		slot1 = this.bezSlot();
		slot2 = this.bezSlot();
	}
	
	
	public void boj(Postava nepritel) {
		System.out.println(this.jmeno + " utok: " + (this.statyPostavy()[2]));
		System.out.println("Obrane cislo " + nepritel.jmeno + " je: " + nepritel.statyPostavy()[3]);
		if ((this.statyPostavy()[2]) > nepritel.statyPostavy()[3]){
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
		System.out.println(this.jmeno + " utok: " + (this.statyPostavy()[2]));
		System.out.println("Obrane cislo " + nepritel.jmeno + " je: " + nepritel.obrana);
		if ((this.statyPostavy()[0]) > nepritel.obrana){
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
			System.out.println(this.jmeno + " presahuje svoje maximum zivotu");
			return 0;
		}	
		this.zivoty += zlataky;
		System.out.println(this.jmeno + " byl dolecen o " + zlataky + " na " + (this.zivoty));
		return this.zivoty;
	}
	
	
	public String info(){
		return ("\n" + this.povolani + " " + this.jmeno + "\nHP: " + this.zivoty + "\nZlataky: "
				+ this.zlataky + "\nLevel: " + this.level + "\n" + "XP: " + this.exp +"\nEnergie: "
				+ this.energie + "\n" + "Sila: " + this.statyPostavy()[0] + "\nInteligence: " + this.statyPostavy()[1]
				+ "\n" + "Utok: " + this.statyPostavy()[2] + "\nObrana: " + this.statyPostavy()[3] + "\nPredmety: " 
				+ slot1.vratNazev() + ", " + slot2.vratNazev()) +"\n";
	}
	
	
	public String getPredmet(Predmet predmet){
		if (predmet.vratCenu() > this.zlataky){
			return "Nemate dost zlata";
		}
		this.zlataky -= predmet.vratCenu();
		this.predmety.add(predmet);
		
		if (predmet.vratSlot() == 1){
			slot1 = predmet;
		}
		else{
			slot2 = predmet;
		}
		return "Uspesne jste koupil " + predmet.vratNazev();
	}
	
	
	public Predmet getslot1(){
		return slot1;
	}
	
	
	public Predmet getslot2(){
		return slot2;
	}
	
	
	public float[] getStaty(Predmet predmet){
		float[] policko = predmet.vratStaty();
		return policko;
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
		float[] poleStatu = {this.sila, this.inteligence, this.utok, this.obrana};
		return poleStatu;
		
	}
	
	public String aktivujQuest(Ukol ukol){
		if (ukol.vratEnergii() > this.energie){
			return (this.jmeno + " ma moc malo energie.");
		}
		this.aktivniQ = true;
		return (this.jmeno + " se vypravil na ukol a ziskal " + ukol.vratExpy());
	}
	
	
	public String levelUP(Postava postava){
		this.level += 1;
		this.exp = 0;
		return (this.jmeno + " dosahnul dost zkusenosti a je ted level " + this.level);
	}
	
	public Predmet bezSlot(){
		Predmet nic = new Nic("NIC!");
		return nic;
	}
}


