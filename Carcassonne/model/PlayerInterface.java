package Carcassonne.model;

import java.io.FileNotFoundException;
import java.util.LinkedList;
public interface PlayerInterface {
	public void piocherTuile(LinkedList<TuileC> sac) throws FileNotFoundException;//Le joueur récupère une tuile du sac qui sera supprimé de ce sac;
	public void affichageTuilePlayer();//fonction qui affiche toutes les tuiles du joueurs;
	public TuileC getTuilePlayer();//le joueur selection la tuile de son paquet;
	//public void addTuile(Plateau p,LinkedList<Tuile> sac);//position correspond à haut bas gauche Droite;
}
