package quest;
import characters.Postava;

public class Ukol {
	protected String nazev;
	protected int pocetExp;
	protected int obtiznost;
	protected int potrebnaEnergie;
	
	public Ukol(Postava postava, String nazev){
		this.potrebnaEnergie = postava.level;
		this.pocetExp = postava.level;
	}
	
	public int vratEnergii(Ukol ukol){
		return this.potrebnaEnergie;
	}
	
	public int vratExpy(Ukol ukol){
		return this.pocetExp;
	}
}