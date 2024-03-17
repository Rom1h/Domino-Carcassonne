package Carcassonne.model;

import Carcassonne.model.Paysage.Direction;

public abstract class Paysage {
	public char type;
	public enum Direction{ALL,NORD,EST,OUEST,SUD;
		
		public boolean equals(Direction dir) {
			return this==NORD&&dir==SUD||this==SUD&&dir==NORD||
					this==EST&&dir==OUEST||this==OUEST&&dir==EST;
		}
		
		public Direction turn() {
			if(this==NORD)return EST;
			if(this==EST)return SUD;
			if(this==SUD)return OUEST;
			else{
				return NORD;
			}
			
		}
	}
	public abstract void turn();
	public boolean equals(Paysage p) {
		return type==p.type;
	}
	public static boolean valide(Paysage p1,Paysage p2,Direction dir, Direction dir2) {
		if(p1.type=='v'&&p2.type=='p') {
			
			((Ville)p1).affiche();
			return ((Ville)p1).hasDirection(dir);
		}
		if(p1.type=='p'&&p2.type=='v') {
			
			return ((Ville)p2).hasDirection(dir2);
		}
		return false;
	}
}
