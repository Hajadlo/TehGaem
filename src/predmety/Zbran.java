package predmety;

import characters.*;

public abstract class Zbran extends Predmet{
	private float utok;
	public Zbran(String nazev){
		super(nazev);
		this.utok = utok;
	}
	public void equipZbran(Predmet predmet, Postava postava){
		Predmet prvniSlot = postava.getslot1();
		prvniSlot = predmet;
	}
	
	public float setUtok(){
		return this.utok;
	}
}