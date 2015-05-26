package quest;

import java.util.Random;

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
	public Ukol setUkol(){
		
		Ukol prvni = new Ukol("Za horami", 5, 3);
		Ukol druhy = new Ukol("Blbustka", 8, 5);
		Ukol treti = new Ukol("Za horami", 15, 6);
		Ukol ctvrty = new Ukol("Za horami", 1, 1);
		Ukol paty= new Ukol("Za horami", 6, 4);
		Ukol sesty = new Ukol("Za horami", 3, 2);
		
		Ukol[] ukoly = {prvni, druhy, treti, ctvrty, paty, sesty};
		Ukol randomQ = (ukoly[new Random().nextInt(ukoly.length)]);
		return randomQ;
	}
	
	
}