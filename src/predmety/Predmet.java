package predmety;

import java.util.Random;

public abstract class Predmet implements PredmetRozhrani{
	protected String nazev;
	
	protected int cena;
	protected int slot;
	
	protected float utok;
	protected float obrana;
	protected float bonusInt;
	protected float bonusStr;
	
	public String proPovolani;
	
	public Predmet(String nazev){
		this.nazev = nazev;
	}
	
	public void koupit(Predmet predmet){
	}
	
	public float[] vratStaty(){
		float[] staty = {this.utok, this.obrana, this.bonusInt, this.bonusStr};
		return staty;
	}

	public int vratCenu() {
		return this.cena;
	}

	public String vratNazev() {
		return this.nazev;
	}
	
	public int vratSlot(){
		return this.slot;
	}
	
	public static Predmet setPredmet(){
		Predmet hulka = new Hul("Cool hulka");
		Predmet kape = new Kape("Cool kape");
		Predmet mecak = new Mec("Cool mecak");
		Predmet krouzkovka = new Platovka("Cool Platovka");
		
		Predmet[] predmety = {hulka, kape, mecak, krouzkovka};
		Predmet randomItem = (predmety[new Random().nextInt(predmety.length)]);
		return randomItem;
	}
}