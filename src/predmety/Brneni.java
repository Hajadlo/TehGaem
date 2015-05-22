package predmety;

import characters.Postava;

public abstract class Brneni extends Predmet{
	private float obrana;
	public Brneni(String nazev, int cena) {
		super(nazev, cena);
		this.obrana = obrana;
	}
	public abstract void vratBrneni(Postava postavicka);
}