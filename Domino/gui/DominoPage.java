package Domino.gui;
import javax.swing.*;

import Domino.model.*;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class DominoPage extends JComponent {
	File file = new File("ressources/domino.jpg");
	String localUrl = file.getPath();
	
	private Background bg = new Background(localUrl);
	
	public DominoPage() throws FileNotFoundException {
		
		//screesize
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)dimension.getWidth();
		int height = (int)dimension.getHeight();
		
		JFrame dominopage = new JFrame();
		dominopage.setSize(width,height);
		
		JPanel paneldomino = new JPanel(new BorderLayout());
		JPanel paneljouer = new JPanel();
		JPanel panelinstru = new JPanel();
		JPanel panelretour = new JPanel();
		JPanel panelquitter = new JPanel();
		JLabel labeldomino = new JLabel(new ImageIcon(bg.getImage()));
		JButton jouer = new JButton("Jouer");
		JButton quitter = new JButton("Quitter");
		JButton instructions = new JButton("Instructions");
		JButton retour = new JButton("Retour");
		
		//enleve l'arrière plan
	    jouer.setContentAreaFilled(false);
		jouer.setFocusable(false);
	    //enlever la bordure
	    jouer.setBorderPainted(false);
	    jouer.setForeground(Color.white);
	    jouer.setFont(new Font("Arial",0,30));
	    
	    instructions.setContentAreaFilled(false);
		instructions.setFocusable(false);
	    instructions.setBorderPainted(false);
	    instructions.setForeground(Color.white);
	    instructions.setFont(new Font("Arial",0,30));
	    
	    retour.setContentAreaFilled(false);
		retour.setFocusable(false);
	    retour.setBorderPainted(false);
	    retour.setForeground(Color.white);
	    retour.setFont(new Font("Arial",0,30));
	    
	    quitter.setContentAreaFilled(false);
		quitter.setFocusable(false);
	    quitter.setBorderPainted(false);
	    quitter.setForeground(Color.white);
	    quitter.setFont(new Font("Arial",0,30));

		jouer.addActionListener((event) ->{
	    		try {
					InstruAvGame instru = new InstruAvGame();
					dominopage.setVisible(false);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    });
	    
	    instructions.addActionListener((event) ->{
	    	try {
	    		InstructionsDomino id = new InstructionsDomino();
	    		dominopage.setVisible(false);
	    	}
	    	catch(FileNotFoundException e) {
	    		e.printStackTrace();
	    	}
	    });
	    
	    retour.addActionListener((event) ->{
	    	try {
				HomePage hp = new HomePage();
				dominopage.setVisible(false);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    });

		quitter.addActionListener((event) ->{
	    	System.exit(0);
	    });

	    Color c=new Color(255,255,255,0);
	    paneljouer.setLayout(new BoxLayout(paneljouer,BoxLayout.LINE_AXIS));
	    paneljouer.add(jouer);
	    paneljouer.setBackground(c);
	    panelinstru.setLayout(new BoxLayout(panelinstru,BoxLayout.LINE_AXIS));
	    panelinstru.add(instructions);
	    panelinstru.setBackground(c);
	    panelretour.setLayout(new BoxLayout(panelretour,BoxLayout.LINE_AXIS));
	    panelretour.add(retour);
	    panelretour.setBackground(c);
	    panelquitter.setLayout(new BoxLayout(panelquitter,BoxLayout.LINE_AXIS));
	    panelquitter.add(quitter);
	    panelquitter.setBackground(c);
	    paneldomino.setLayout(new BoxLayout(paneldomino,BoxLayout.PAGE_AXIS));
	    
	    paneldomino.setBackground(c);
	    paneldomino.add(paneljouer);
	    paneldomino.add(panelinstru);
	    paneldomino.add(panelretour);
	    paneldomino.add(panelquitter);
	    
	    dominopage.setContentPane(new JPanel() {
	        public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(bg.getImage(), 0, 0, width, height, this);
	        }
	    });
	    
		dominopage.add(paneldomino);
	    dominopage.setVisible(true);
	    dominopage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	
	public static void main(String[] args) throws FileNotFoundException {
		DominoPage hp = new DominoPage();
	}
}
