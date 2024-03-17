package Domino.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import Domino.model.*;
import java.io.FileNotFoundException;

import javax.swing.*;

public class InstructionsDomino extends JComponent{

	private Background bg = new Background("/home/lilia/pooig/Domino/ressources/domino.jpg");
	
	public InstructionsDomino() throws FileNotFoundException{
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)dimension.getWidth();
		int height = (int)dimension.getHeight();
		
		JFrame instrudomino = new JFrame();
		instrudomino.setSize(width,height);	
		instrudomino.setContentPane(new JPanel() {
			public void paint(Graphics g) {
				super.paintComponent(g);
	            g.drawImage(bg.getImage(), 0, 0, width, height, this);
	        }
		});
		
		JPanel panelretour = new JPanel();
		JPanel panel = new JPanel();
		JButton retour = new JButton("Retour");
		retour.setContentAreaFilled(false);
	    retour.setBorderPainted(false);
	    retour.setForeground(Color.white);
	    retour.setFont(new Font("Arial",0,30));
	    
	    retour.addActionListener((event) ->{
	    	try {
				DominoPage dp = new DominoPage();
				instrudomino.setVisible(false);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    });
	    
	    Color c=new Color(255,255,255,0);
	    panelretour.setLayout(new BoxLayout(panelretour,BoxLayout.LINE_AXIS));
	    panelretour.add(retour);
	    panelretour.setBackground(c);
		
		
		//récupérer l'objet Graphics
	    Graphics g = bg.getImage().getGraphics();
	    //définir le font
	    g.setFont(g.getFont().deriveFont(30f));
	    //afficher le texte sur les coordonnées(x=50, y=150)
	    g.drawString("Règles des dominos :", 100, 220);
	    g.drawString("Le but du jeu est d’être le premier à poser tous ses dominos.", 100, 360);
	    g.drawString("Le joueur ayant le dé le plus élevé commence la partie et pose son domino au centre de la table", 100, 400);
	    g.drawString("Le joueur suivant doit poser l’un de ses dominos dont l’un des côtés est identique à un côté du premier domino.", 100, 440);
	    g.drawString("Puis c’est au joueur suivant de jouer et ainsi de suite.", 100, 480);
	    g.drawString("Les joueurs peuvent poser leur domino à l’une ou l’autre des extrémités de la chaîne.", 100, 520);
	    g.drawString("Si des joueurs n'ont pas pu finir, ils marquent alors autant de points qu’indiqués sur leurs dominos restants.", 100, 560);
	    g.drawString("Si la partie est bloquée (aucun joueur ne peut ajouter de domino) chacun compte les points qui lui restent en mains.", 100, 600);
	    g.drawString("Une partie peut se jouer sur plusieurs manches, le gagnant est celui qui totalise le moins de points.", 100, 640);
	    g.dispose();
	    
	    panel.add(panelretour);
	    instrudomino.add(panel);
		instrudomino.setVisible(true);
		instrudomino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		InstructionsDomino id = new InstructionsDomino();
	}

}
