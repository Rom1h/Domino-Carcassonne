package Domino.model;
public interface TuileInterface {
	public boolean hasLeft();
	public boolean hasRight();
	public boolean hasTop();
	public boolean hasBot();
	
	public boolean positionValide(Tuile t,int n);//verifie si on peu placer la tuile t à la position n(Top,Bot,Left,Right);
	
	public void setTuile(Tuile t,int n);//place la tuile T à la position n;
	
}
