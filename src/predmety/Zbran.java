package predmety;

import characters.*;

public abstract class Zbran extends Predmet{
	private float utok;
	public Zbran(String nazev){
		super(nazev, cena);
		this.utok = utok;
	}
	public abstract void equipZbran(Postava postavicka);
}