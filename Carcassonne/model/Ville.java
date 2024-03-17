package Carcassonne.model;

import java.util.LinkedList;

import Carcassonne.model.Paysage.Direction;

public class Ville extends Paysage {
	LinkedList<Direction> dir=new LinkedList<Direction>();
	
	Ville(Direction... dir){
		super.type='v';
		for(Direction d:dir) {
			this.dir.add(d);
		}
	}
	public boolean dirValide(Ville v) {
		for(Direction d :dir) {
			for(Direction d2 :v.dir) {
				if(d.equals(d2))return true;
			}
		}
		return false;
	}
	public boolean hasDirection(Direction d) {
		for(Direction d1:dir) {
			if(d1==d)return true;
		}
		return false;
	}
	public void turn() {
		
		for(int i=0;i<dir.size();i++) {
			Direction d=dir.get(i).turn();
			
			dir.remove(i);
			dir.add(i, d);
		}
	}
	public void affiche() {
		dir.forEach(e->System.out.println(e));
	}
	public static void main(String[] args) {
		Ville v=new Ville(Direction.SUD,Direction.OUEST);
		v.affiche();
		v.turn();
		v.affiche();
		Ville v2=new Ville(Direction.SUD);
		System.out.println(v.dirValide(v2));
	}
}
