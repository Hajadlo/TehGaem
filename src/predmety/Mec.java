package predmety;


public class Mec extends Zbran{
	public Mec(String nazev) {
		super(nazev);
		this.mageOnly = true;
		this.utok = 0;
		this.obrana = 15;
		this.bonusStr = 10;
		this.bonusInt = 0;
	}
}
