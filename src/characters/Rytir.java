package characters;


public class Rytir extends Postava{
	
	public Rytir(String jmeno) {
		super(jmeno);
		this.zivoty = 50;
		this.maxHP = this.zivoty;
		this.baseSila = 15;
		this.baseInt = 10;
		this.utok = 0;
		this.obrana = 0;
		this.povolani = "Rytir";
	}
}