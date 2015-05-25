package characters;


public class Rytir extends Postava{
	
	public Rytir(String jmeno) {
		super(jmeno);
		this.zivoty = 50;
		this.maxHP = this.zivoty;
		this.sila = 15;
		this.obrana = 20;
		this.inteligence = 10;
		this.utok = 0;
		this.obrana = 0;
		this.povolani = "Rytir";
		
		
		
		
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