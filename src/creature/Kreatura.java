package creature;

import java.util.Random;

public class Kreatura {
	public String jmeno;
	public int zivoty;
	public float obrana;
	
	public Kreatura(String jmeno, float obrana){
		this.jmeno = jmeno;
		this.obrana = obrana;
	}
	
	public static Kreatura setKreatura(){
		Kreatura kentaur = new Kreatura("Vórèíf", 15);
		Kreatura ogr = new Kreatura("Ogre", 25);
		Kreatura zaba = new Kreatura("Zabak Rabak", 10);
		
		Kreatura[] kreaturky = {kentaur, ogr, zaba};
		Kreatura randomC = (kreaturky[new Random().nextInt(kreaturky.length)]);
		return randomC;
	}
}