package Domino.model;

import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.text.TabableView;

import Carcassonne.model.PlayerC;
import Carcassonne.model.TuileC;

public class Plateau {
	public Tuile[][] plateau;
	Tuile mid;
	@SuppressWarnings("unchecked")
	public Plateau(int n) {
		plateau=new Tuile[n*2][n*2];
	}
	public void setFirstTuile(Tuile t) {
		if(plateau[plateau.length/2][plateau.length/2]==null) {
			plateau[plateau.length/2][plateau.length/2]=t;
		}
		
	}
	//verifie si il y a bien une tuile autour de la position i,j;
	public boolean checkTuile(int i,int j) {
		return plateau[i-1][j]!=null|| plateau[i+1][j]!=null|| plateau[i][j-1]!=null|| plateau[i][j+1]!=null;
	}
	
	//on verifie si la case est vide
	public boolean estLibre(int i, int j) {
		return (plateau[i][j] == null);
	}
	
	
	public void setTuile(Tuile t,int i,int j,Player p) {
		plateau[i][j]=t;
		if(p!=null)p.scorePlayer(this, i, j);
	}	
	
	public String affichePlateauDomino() {
		String s="";
		for(int i=getFirstLine();i<=getLastLine();i++) {
			int j=getFirstCollums();
			for(int k=getFirstCollums();k<=getLastCollums();k++) {				
				if(plateau[i][j]!=null)s+=" "+((TuileD)plateau[i][j]).up[0]+" "+((TuileD)plateau[i][j]).up[1]+" "+((TuileD)plateau[i][j]).up[2]+" ";
				else s+="       ";
				j++;
			}
			
			s+="\n";
			j=getFirstCollums();
			for(int k=getFirstCollums();k<=getLastCollums();k++) {
				if(plateau[i][j]!=null) {
					s+=((TuileD)plateau[i][j]).left[0]+"     "+((TuileD)plateau[i][j]).right[0];
				}
				else s+="       ";
				j++;
			}
			
			s+="\n";
			
				j=getFirstCollums();
			for(int k=getFirstCollums();k<=getLastCollums();k++) {
				if(plateau[i][j]!=null) {
					s+=((TuileD)plateau[i][j]).left[1]+"("+i+","+""+j+")"+((TuileD)plateau[i][j]).right[1];
				}
				
				else s+="       ";
				j++;
			}
			
			s+="\n";
			
				j=getFirstCollums();
			for(int k=getFirstCollums();k<=getLastCollums();k++)  {
				if(plateau[i][j]!=null)s+=((TuileD)plateau[i][j]).left[2]+"     "+((TuileD)plateau[i][j]).right[2];
				else s+="       ";
				j++;
			}
			
			s+="\n";
			
				j=getFirstCollums();
			for(int k=getFirstCollums();k<=getLastCollums();k++) {
				if(plateau[i][j]!=null) {
					s+=" "+((TuileD)plateau[i][j]).down[0]+" "+((TuileD)plateau[i][j]).down[1]+" "+((TuileD)plateau[i][j]).down[2]+" ";
				}
				else s+="       ";
				j++;
			}
			s+="\n";
			
			
			
			}
		
		return s;
	}
	public int getFirstLine() {
		for(int i=0;i<plateau.length;i++) {
			for(int j=0;j<plateau.length;j++) {
				if(plateau[i][j]!=null) {
					return i;
				};
			}
		}
		return 0;
	}
	public int getFirstCollums() {
		for(int j=0;j<plateau.length;j++) {
			for(int i=0;i<plateau.length;i++) {
				if(plateau[i][j]!=null) {
					return j;
				};
			}
		}
		return 0;
	}
	public int getLastLine() {
		for(int i=plateau.length-1;i>0;i--) {
			for(int j=0;j<plateau.length;j++) {
				if(plateau[i][j]!=null) {
					return i;
				};
			}
		}
		return 0;
	}
	public int getLastCollums() {
		for(int j=plateau.length-1;j>0;j--) {
			for(int i=0;i<plateau.length;i++) {
				if(plateau[i][j]!=null) {
					return j;
				};
			}
		}
		return 0;

	}
	public void setTuile(TuileC t, int i, int j, PlayerC p) {
		plateau[i][j]=t;
	}
}
