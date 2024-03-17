package Domino.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import Domino.model.*;
import java.io.FileNotFoundException;
import java.io.File;
import javax.swing.*;

public class InstructionsDomino extends JComponent{
	File file = new File("ressources/domino.jpg");
		
	String localUrl = file.getPath();
	private Background bg = new Background(localUrl);
	
	public InstructionsDomino() throws FileNotFoundException{
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)dimension.getWidth();
		int height = (int)dimension.getHeight();
		
		JFrame instrudomino = new JFrame();
		instrudomino.setSize(width,height);	
		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel panelretour = new JPanel();
		JButton retour = new JButton("Retour");
		
	    //enleve l'arrière plan
	    retour.setContentAreaFilled(false);
		retour.setFocusable(false);
	    //enlever la bordure
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
	    panelretour.add(retour);
	    panelretour.setBackground(c);

		
	    
	    panel.setBackground(c);
	    panel.add(panelretour);

		instrudomino.setContentPane(new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
	            g.drawImage(bg.getImage(), 0, 0, width, height, this);
	        }
		});
		
		
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
	    
	    instrudomino.getContentPane().add(panel);
		instrudomino.setVisible(true);
		instrudomino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		InstructionsDomino id = new InstructionsDomino();
	}

}
