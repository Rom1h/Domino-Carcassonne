package Domino.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import Domino.model.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;

import Carcassonne.gui.InstruGame;

public class InstruAvGame extends JPanel{

		File file = new File("ressources/domino.jpg");
		String localUrl = file.getPath();
		private Background bg = new Background(localUrl);
	
	InstruAvGame() throws FileNotFoundException{
		//screesize
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)dimension.getWidth();
		int height = (int)dimension.getHeight();
		
		JFrame instrupage = new JFrame();
		instrupage.setSize(width,height);
		
		JPanel panelhome = new JPanel(new BorderLayout());
		JPanel panel1v1 = new JPanel();
		JPanel panelbot = new JPanel();
		JPanel panelretour = new JPanel();
		JButton mode1 = new JButton("Mode 1v1");
		JButton modeBot=new JButton("Jouer contre l'ordinateur");
		JButton retour = new JButton("Retour");

		//enleve l'arrière plan
	    mode1.setContentAreaFilled(false);
		mode1.setFocusable(false);
	    //enlever la bordure
	    mode1.setBorderPainted(false);
	    mode1.setForeground(Color.white);
	    mode1.setFont(new Font("Arial",0,30));
	    
	    modeBot.setContentAreaFilled(false);
		modeBot.setFocusable(false);
	    modeBot.setBorderPainted(false);
	    modeBot.setForeground(Color.white);
	    modeBot.setFont(new Font("Arial",0,30));

		retour.setContentAreaFilled(false);
		retour.setFocusable(false);
	    retour.setBorderPainted(false);
	    retour.setForeground(Color.white);
	    retour.setFont(new Font("Arial",0,30));

		
	    mode1.addActionListener((event) ->{
	    	try {
				DominoGame dg = new DominoGame();
				instrupage.setVisible(false);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    });
	    modeBot.addActionListener((event) ->{
	    	try {
				BotGame dg = new BotGame();
				instrupage.setVisible(false);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    });

		retour.addActionListener((event) ->{
	    	try {
				DominoPage hp = new DominoPage();
				instrupage.setVisible(false);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    });

		
	    Color c=new Color(255,255,255,0);
	    panel1v1.add(mode1);
	    panel1v1.setBackground(c);
	    panelbot.add(modeBot);
	    panelbot.setBackground(c);
	    panelretour.add(retour);
	    panelretour.setBackground(c);
	    panelhome.setLayout(new BoxLayout(panelhome,BoxLayout.PAGE_AXIS));
		
	    
	    panelhome.setBackground(c);
	    panelhome.add(panel1v1);
	    panelhome.add(panelbot);
		panelhome.add(panelretour);

		//récupérer l'objet Graphics
	    Graphics g = bg.getImage().getGraphics();
	    //définir le font
	    g.setFont(g.getFont().deriveFont(40f));
	    //afficher le texte sur les coordonnées(x=50, y=150)
	    g.drawString("Bienvenue dans une nouvelle partie !", width/3-30, 300);
	    g.drawString("Le but du jeu est d’être le premier à poser tous ses dominos.", width/5, 450);
	    g.drawString("Les joueurs peuvent poser leurs dominos à l’une ou l’autre des", width/5, 500);
        g.drawString("extrémités de la chaîne.", width/5, 550);
	    g.dispose();
	    
	    instrupage.setContentPane(new JPanel() {
	        public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(bg.getImage(), 0, 0, width, height, this);
	        }
	    });
		
	    instrupage.getContentPane().add(panelhome);
		instrupage.setVisible(true);
		instrupage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public static void main(String[] args) throws FileNotFoundException{
		InstruAvGame instru = new InstruAvGame();
	}

}
