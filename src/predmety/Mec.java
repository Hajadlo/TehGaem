package predmety;


public class Mec extends Zbran{
	public Mec(String nazev) {
		super(nazev);
		this.mageOnly = true;
		this.utok = 15;
		this.obrana = 0;
		this.bonusStr = 10;
		this.bonusInt = 0;
	}
}
