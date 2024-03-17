package Domino.model;

import java.util.LinkedList;
public interface PlayerInterface {
	public void piocherTuile(LinkedList<Tuile> sac);//Le joueur récupère une tuile du sac qui sera supprimé de ce sac;
	public void affichageTuilePlayer();//fonction qui affiche toutes les tuiles du joueurs;
	public Tuile getTuilePlayer();//le joueur selection la tuile de son paquet;
	public void addTuile(Plateau p,LinkedList<Tuile> sac);//position correspond à haut bas gauche Droite;
}
