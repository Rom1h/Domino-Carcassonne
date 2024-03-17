package Domino.gui;
import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import Domino.model.*;
public class HomePage extends JComponent {
	
	File file = new File("Domino/ressources/home.jpg");
	String localUrl = file.getPath();
	private Background bg = new Background(localUrl);
	
	public HomePage() throws FileNotFoundException {
		
		//screesize
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)dimension.getWidth();
		int height = (int)dimension.getHeight();
		
		JFrame homepage = new JFrame();
		homepage.setSize(width,height);
		
		JPanel panelhome = new JPanel(new BorderLayout());
		JPanel paneljouerd = new JPanel();
		JPanel paneljouerc = new JPanel();
		JPanel panelquitter = new JPanel();
		JButton jouerd = new JButton("Jouer aux dominos");
		JButton jouerc = new JButton("Jouer à carcassone");
		JButton quitter = new JButton("Quitter");
		
	    //enleve l'arrière plan
	    jouerd.setContentAreaFilled(false);
	    //enlever la bordure
	    jouerd.setBorderPainted(false);
	    jouerd.setForeground(Color.white);
	    jouerd.setFont(new Font("Arial",0,30));
	    
	    jouerc.setContentAreaFilled(false);
	    jouerc.setBorderPainted(false);
	    jouerc.setForeground(Color.white);
	    jouerc.setFont(new Font("Arial",0,30));
	    
	    
	    quitter.setContentAreaFilled(false);
	    quitter.setBorderPainted(false);
	    quitter.setForeground(Color.white);
	    quitter.setFont(new Font("Arial",0,30));
	    
	    
	    jouerd.addActionListener((event) ->{
	    	try {
				DominoPage dp = new DominoPage();
				homepage.setVisible(false);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    });
	    
	    jouerc.addActionListener((event) ->{
	    	try {
				CarcassonnePage cp = new CarcassonnePage();
				homepage.setVisible(false);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    });

		quitter.addActionListener((event) ->{
	    	System.exit(0);
	    });
		
	    Color c=new Color(255,255,255,0);
	    paneljouerd.add(jouerd);
	    paneljouerd.setBackground(c);
	    paneljouerc.add(jouerc);
	    paneljouerc.setBackground(c);
	    panelquitter.add(quitter);
	    panelquitter.setBackground(c);
	    panelhome.setLayout(new BoxLayout(panelhome,BoxLayout.PAGE_AXIS));
		
	    
	    panelhome.setBackground(c);
	    panelhome.add(paneljouerd);
	    panelhome.add(paneljouerc);
	    panelhome.add(panelquitter);
	    
	    homepage.setContentPane(new JPanel() {
	        public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(bg.getImage(), 0, 0, width, height, this);
	        }
	    });
		
	    homepage.getContentPane().add(panelhome);
		homepage.setVisible(true);
		homepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	}
		
	
	public static void main(String[] args) throws FileNotFoundException {
		HomePage hp = new HomePage();
	}
}
	
