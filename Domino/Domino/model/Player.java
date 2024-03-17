package Domino.model;

import java.util.LinkedList;
import java.util.Scanner;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
public class Player implements PlayerInterface {
	public Tuile courant;
	public String name;
	public LinkedList<Tuile> playerDomino = new LinkedList<>();
	public int score = 0;
	public Player(String name) {
		this.name=name;
	}
	
	public void piocherTuile(LinkedList<Tuile> sac) {
		int rd =(int)(Math.random()*sac.size());
		courant=sac.get(rd);
		sac.remove(rd);
		
	}

	@Override
	public void affichageTuilePlayer() {
		((TuileD)courant).show();
		
	}
	@Override
	public Tuile getTuilePlayer() {
		try {
			return courant;
		} catch (NullPointerException e) {
			System.out.println("erreur");
			return null;
		}
	}

	public void dominoPlayer(Tuile tuile){
		playerDomino.add(tuile);
	}
	public void setTuile(Plateau p,LinkedList<Tuile> sac) {
		if(courant==null) {
			piocherTuile(sac);
		}
		((TuileD)courant).show();
		Scanner sc = new Scanner(System.in);
		System.out.println(name +" Veux-tu placer ton domino (P), le tourner (T), passer ton tour (D) ou arrêter la partie (E)?");
		String res = sc.nextLine();
		String placer = "P";
		String tourner = "T";
		String passer = "D";
		String exit = "E";
		if(res.equals(placer)) {
			System.out.println("Choisit une ligne : ");
			int i = sc.nextInt();
			System.out.println("Et une colonne : ");
			int j = sc.nextInt();
			
			if(courant.positionValide(p,i,j)) {
				
				p.setTuile(courant, i, j,this);
				courant=null;
				sac.remove(courant);
				
			}
			else {
				System.out.println("Tu ne peux pas mettre le domino ici !");
				setTuile(p,sac);
			}
		}
		else if(res.equals(tourner)) {
			courant.turn();
			setTuile(p,sac);
		}
		else if(res.equals(passer)) {
			piocherTuile(sac);
			
		}
		else if(res.equals(exit)) {
			System.exit(0);
		}
	}
	
	public void scorePlayer(Plateau p,int i,int j) {
		score+=getScore(p, i, j);
	}
	public int  getScore(Plateau p,int i,int j) {
		int score=0;
		
		if(p.plateau[i-1][j]!=null) {
			for(int x:((TuileD)p.plateau[i-1][j]).down) {
				score+=x;
				
			}
		}
		if(p.plateau[i+1][j]!=null) {
			
			for(int x:((TuileD)p.plateau[i+1][j]).up) {
				score+=x;
			}
		}
		if(p.plateau[i][j-1]!=null) {
			for(int x:((TuileD)p.plateau[i][j-1]).right) {
				score+=x;
			}
		}
		if(p.plateau[i][j+1]!=null) {
			for(int x:((TuileD)p.plateau[i][j+1]).left) {
				score+=x;
			}
		}
		
		return score;
		
		
	}

	@Override
	public void addTuile(Plateau p, LinkedList<Tuile> sac) {
	}
	
	
	
}