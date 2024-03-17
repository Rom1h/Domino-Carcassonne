package Domino.model;

import java.util.LinkedList;

public class Bot extends Player{
	public int i=-1;
	public int j=-1;
	public Tuile t;
	public Bot() {
		super("Ordinateur");
	}
	
	public void setTuile(Plateau p,LinkedList<Tuile> sac) {
		this.i=-1;
		this.j=-1;
		if(courant==null) {
			piocherTuile(sac);
		}
		int score=0;	
		int x=0;
		while(x<3) {		
			for(int i=p.getFirstLine()-1;i<=p.getLastLine()+1;i++) {		
				for(int j=p.getFirstCollums()-1;j<=p.getLastCollums()+1;j++) {				
					if(courant.positionValide(p, i, j)) {
						if(score<getScore(p, i, j)) {
							score=getScore(p, i, j);
							t=new TuileD((TuileD)courant);
							this.i=i;
							this.j=j;
						}
					}					
				}
			}
			
			courant.turn();
			x++;
		}
		if(this.i!=-1) {
			p.setTuile(t, i, j, this);
			System.out.println(super.score);
			courant=null;
		}
		else {
			piocherTuile(sac);
		}
	
	}
}
