package characters;

public class Kouzelnik extends Postava{
	
	public Kouzelnik(String jmeno){
		super(jmeno);
		this.zivoty = 25;
		this.maxHP = this.zivoty;
		this.sila = 10;
		this.obrana = 10;
		this.inteligence = 25;
		this.utok = 0;
		this.obrana = 0;
		this.povolani = "Kouzelnik";
	}
}