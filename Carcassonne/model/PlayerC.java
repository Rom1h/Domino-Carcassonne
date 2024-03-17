package Carcassonne.model;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
public class PlayerC implements PlayerInterface {
	public TuileC courant;
	public TuileC ancien;
	public String name;
	public String color;
	public LinkedList<TuileC> playerCarcassone = new LinkedList<>();
	public int score = 0;
	public int pion = 7;
	public PlayerC(String name) {
		this.name=name;
	}
	
	public void piocherTuile(LinkedList<TuileC> sac) throws FileNotFoundException {
		int rd =(int)(Math.random()*sac.size());
		courant= sac.get(rd);
		sac.remove(rd);
		
	}

	public void piocherNouvelleTuile(LinkedList<TuileC> sac) throws FileNotFoundException{
		int rd =(int)(Math.random()*sac.size());
		ancien = courant;
		courant= sac.get(rd);
		sac.remove(rd);
		sac.add(ancien);
	}

	public void carcassonnePlayer(TuileC courant2){
		playerCarcassone.add(courant2);
	}

    @Override
    public void affichageTuilePlayer() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public TuileC getTuilePlayer() {
		return courant;
    }

	public void removePion(){
		pion--;
	}

	
	
	
}
