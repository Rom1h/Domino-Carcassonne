package Carcassonne.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import Domino.model.*;
import Domino.gui.*;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.*;

public class InstructionsCarcassonne extends JPanel{

	File file = new File("ressources/Carcassonne.jpg");
	String localUrl = file.getPath();
	private Background bg = new Background(localUrl);
	
	public InstructionsCarcassonne() throws FileNotFoundException{
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)dimension.getWidth();
		int height = (int)dimension.getHeight();
		
		JFrame instrucarcassonne = new JFrame();
		instrucarcassonne.setSize(width,height);
		
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
				CarcassonnePage cp = new CarcassonnePage();
				instrucarcassonne.setVisible(false);
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
	    
	    instrucarcassonne.setContentPane(new JPanel() {
	        public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(bg.getImage(), 0, 0, width, height, this);
	        }
	    });
		
		//récupérer l'objet Graphics
	    Graphics g = bg.getImage().getGraphics();
	    //définir le font
	    g.setFont(g.getFont().deriveFont(30f));
		g.setColor(Color.white);
	    //afficher le texte sur les coordonnées(x=50, y=150)
	    g.drawString("Règles de Carcassonne :", 100, 220);
	    g.drawString("Les joueurs posent des tuiles tour après tour. Faites attention,", 100, 360);
	    g.drawString("les tuiles doivent correspondrent ! C'est ainsi,que le paysage", 100, 400);
	    g.drawString("formé de routes, de villes, d'abbayes et de prés sera créé et", 100, 440);
	    g.drawString("développé. Vous pourez placer vos partisans sur ces mêmes tuiles.", 100, 480);
	    g.dispose();
		
	    instrucarcassonne.getContentPane().add(panel);
		instrucarcassonne.setVisible(true);
		instrucarcassonne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		InstructionsCarcassonne id = new InstructionsCarcassonne();
	}

}
