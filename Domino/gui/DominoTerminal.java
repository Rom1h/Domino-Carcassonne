package Domino.gui;

import java.util.LinkedList;
import java.util.Scanner;

import Domino.model.*;

public class DominoTerminal {
	public static void main(String[] args) {
		
		Plateau p=new Plateau(30);
		LinkedList<Tuile> sac=new LinkedList<>();
		TuileD t=new TuileD(sac,30);
		Tuile first= sac.getFirst();
		p.setFirstTuile(first);
		sac.remove(first);	
		Scanner sc = new Scanner(System.in);
		System.out.println("Veux tu jouer contre l'ordinateur(B) ou bien contre un vrai joueur(J)");
		String mode=sc.next();
		if(mode.equals("B")){
			Player pl=new Player("Player 1");		
			Player pl1=new Bot();
			while(!sac.isEmpty()) {
				System.out.println(p.affichePlateauDomino());
				pl.setTuile(p,sac);	
				if(!sac.isEmpty()) {
					pl1.setTuile(p,sac);
				}
			}
			if(pl.score>pl1.score) {
				System.out.println("Victoir du joueur");
			}
			else if(pl.score==pl1.score) {
				System.out.println("Egalité");
			}
			else {
				System.out.println("Victoire du Bot");
			}
		}
		else {
		Player pl=new Player("Player 1");			
		Player pl1=new Player("Player 2");
		
			while(!sac.isEmpty()) {
				System.out.println(p.affichePlateauDomino());
				pl.setTuile(p,sac);	
				System.out.println(p.affichePlateauDomino());
				if(!sac.isEmpty()) {
					pl1.setTuile(p,sac);
				}
			}
			if(pl.score>pl1.score) {
				System.out.println("Victoire du joueur");
			}
			else if(pl.score==pl1.score) {
				System.out.println("Egalité");
			}
			else {
				System.out.println("Victoire du Bot");
			}
		}
		
		}
	
}
