package Domino.model;

public abstract class Tuile{

	public abstract void turn();
	public abstract boolean positionValide(Plateau p,int i,int j);
}
