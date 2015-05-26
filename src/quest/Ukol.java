package quest;

public class Ukol {
	public String nazev;
	protected int potrebnaEnergie;
	public int odmena;
	
	public Ukol(String nazev, int potrebnaEnergie, int odmena){
		this.nazev = nazev;
		this.potrebnaEnergie = potrebnaEnergie;
		this.odmena = odmena;
	}
	
	public int vratEnergii(){
		return this.potrebnaEnergie;
	}
	
	
}