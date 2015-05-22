package predmety;

import characters.Postava;

public abstract class Predmet implements PredmetRozhrani{
	protected String nazev;
	protected static int cena;
	
	public Predmet(String nazev, int cena){
		this.nazev = nazev;
		this.cena = cena;
	}
	
	public void koupit(Postava postavicka, Predmet predmetek){
		
	}
	
	public int vratCenu(Predmet predmet){
		return predmet.cena;
	}
	
	public String vratNazev(Predmet predmet){
		return predmet.nazev;
	}
}