package predmety;

import characters.Postava;

public abstract class Predmet implements PredmetRozhrani{
	protected String nazev;
	protected int cena;
	
	public Predmet(String nazev){
		this.nazev = nazev;
		this.cena = cena;
	}
	
	public void koupit(Postava postavicka, Predmet predmetek){
		
	}
	
	public int vratCenu(){
		return this.cena;
	}
	
	public String vratNazev(){
		return this.nazev;
	}
}