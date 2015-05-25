package predmety;

public abstract class Predmet implements PredmetRozhrani{
	protected String nazev;
	
	protected int cena;
	protected int slot;
	
	protected float utok;
	protected float obrana;
	protected float bonusInt;
	protected float bonusStr;
	
	protected boolean mageOnly;
	
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

}