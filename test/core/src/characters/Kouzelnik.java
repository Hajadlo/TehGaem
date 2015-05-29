package characters;

public class Kouzelnik extends Postava{
	
	public Kouzelnik(String jmeno){
		super(jmeno);
		this.zivoty = 30;
		this.maxHP = this.zivoty;
		this.baseSila = 10;
		this.baseInt = 25;
		this.utok = 0;
		this.obrana = 0;
		this.povolani = "Kouzelnik";
	}
}