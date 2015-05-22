package characters;

import creature.Kreatura;


public class Kouzelnik extends Postava{
	
	public Kouzelnik(String jmeno){
		super(jmeno);
		this.zivoty = 25;
		this.sila = 10;
		this.obrana = 10;
		this.inteligence = 25;
		this.utok = this.inteligence; // + itemek!
		this.povolani = "Kouzelnik";
	}
}