package predmety;

import characters.Postava;

public class Platovka extends Brneni{
	static boolean mageOnly = false;
	private float bonusStr;
	public Platovka(String nazev, int cena) {
		super(nazev, cena);
		this.bonusStr = bonusStr;
	}
	@Override
	public void vratBrneni(Postava postavicka) {
		// TODO Auto-generated method stub
		
	}
	
}