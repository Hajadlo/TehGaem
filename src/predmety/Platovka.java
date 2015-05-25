package predmety;


public class Platovka extends Brneni{
	public Platovka(String nazev) {
		super(nazev);
		this.mageOnly = false;
		this.utok = 0;
		this.obrana = 15;
		this.bonusStr = 10;
		this.bonusInt = 0;
	}
}