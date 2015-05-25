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
		
		
		
		this.sila += this.statyPredmetu(slot1)[3] + this.statyPredmetu(slot2)[3];
		this.inteligence += this.statyPredmetu(slot1)[2] + this.statyPredmetu(slot2)[2];
		if (this.povolani == "Kouzelnik"){
			this.utok += this.statyPredmetu(slot1)[0] + this.inteligence;
		}
		else{
			this.utok += this.statyPredmetu(slot1)[0] + this.sila;
		}
		this.obrana += this.statyPredmetu(slot2)[1];
	}
}