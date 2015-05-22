package characters;


public class Rytir extends Postava{
	
	public Rytir(String jmeno) {
		super(jmeno);
		this.zivoty = 50;
		this.maxHP = this.zivoty;
		this.sila = 15;
		this.obrana = 20;
		this.inteligence = 10;
		this.utok = this.sila; // + itemek!
		this.povolani = "Rytir";
	}
}