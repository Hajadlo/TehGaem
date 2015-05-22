package predmety;

import characters.Postava;

public abstract class Brneni extends Predmet{
	private float obrana;
	public Brneni(String nazev, int cena) {
		super(nazev, cena);
		this.obrana = obrana;
	}
	public void equipBrneni(Predmet predmet, Postava postava){
		Predmet druhySlot = postava.getslot2();
		druhySlot = predmet;
	}
	
	public float getObrana(Brneni brneni){
		return this.obrana;
	}
}