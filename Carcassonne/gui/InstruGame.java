package Carcassonne.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import Domino.gui.CarcassonnePage;
import Domino.model.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;

import Carcassonne.gui.InstruGame;

public class InstruGame extends JPanel{

		File file = new File("ressources/Carcassonne.jpg");
		String localUrl = file.getPath();
		private Background bg = new Background(localUrl);
	
        public InstruGame() throws FileNotFoundException{
		//screesize
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)dimension.getWidth();
		int height = (int)dimension.getHeight();
		
		JFrame instrupage = new JFrame();
		instrupage.setSize(width,height);
		
		JPanel panelhome = new JPanel(new BorderLayout());
        JPanel paneljouer = new JPanel();
		JPanel panelretour = new JPanel();
        JButton jouer = new JButton("Continuer");
		JButton retour = new JButton("Retour");

        //enleve l'arrière plan
		jouer.setContentAreaFilled(false);
		jouer.setFocusable(false);
	    //enlever la bordure
	    jouer.setBorderPainted(false);
	    jouer.setForeground(Color.white);
	    jouer.setFont(new Font("Arial",0,30));

		retour.setContentAreaFilled(false);
		retour.setFocusable(false);
	    retour.setBorderPainted(false);
	    retour.setForeground(Color.white);
	    retour.setFont(new Font("Arial",0,30));

        jouer.addActionListener((event) ->{
	    	try {
				TuileCarcassonne tuile = new TuileCarcassonne();
				instrupage.setVisible(false);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    });



		retour.addActionListener((event) ->{
	    	try {
				CarcassonnePage hp = new CarcassonnePage();
				instrupage.setVisible(false);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    });

		
	    Color c=new Color(255,255,255,0);
        paneljouer.setLayout(new BoxLayout(paneljouer,BoxLayout.LINE_AXIS));
	    paneljouer.add(jouer);
	    paneljouer.setBackground(c);
	    panelretour.add(retour);
	    panelretour.setBackground(c);
	    panelhome.setLayout(new BoxLayout(panelhome,BoxLayout.PAGE_AXIS));
		
	    
	    panelhome.setBackground(c);
        panelhome.add(paneljouer);
		panelhome.add(panelretour);

		//récupérer l'objet Graphics
	    Graphics g = bg.getImage().getGraphics();
	    //définir le font
	    g.setFont(g.getFont().deriveFont(40f));
	    //afficher le texte sur les coordonnées(x=50, y=150)
	    g.drawString("Bienvenue dans une nouvelle partie !", width/3-30, 250);
	    g.drawString("Vous devez poser la tuile que vous piochez de façon à ce", width/5, 400);
        g.drawString("qu’elle continue le paysage et l’illustration. Dans de très", width/5, 440);
	    g.drawString("rares cas, il est possible que vous ne puissiez pas placer", width/5, 480);
        g.drawString("la tuile. Remettez alors la tuile dans le sac et piochez-en", width/5, 520);
        g.drawString("une nouvelle. Vous pouvez poser un partisan (un pion) sur la", width/5, 560);
	    g.drawString("tuile que vous venez de placer.", width/5, 600);
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
		InstruGame instru = new InstruGame();
	}

}

