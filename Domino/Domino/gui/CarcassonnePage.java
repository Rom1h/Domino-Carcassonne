package Domino.gui;
import Carcassonne.gui.InstruGame;
import Carcassonne.gui.InstructionsCarcassonne;
import Carcassonne.gui.TuileCarcassonne;

import javax.swing.*; 
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import Domino.model.*;
public class CarcassonnePage extends JComponent {
	File file = new File("Domino/ressources/Carcassonne.jpg");
	String localUrl = file.getPath();
	private Background bg = new Background(localUrl);
	
	public CarcassonnePage() throws FileNotFoundException {
		
		//screesize
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)dimension.getWidth();
		int height = (int)dimension.getHeight();
		
		JFrame carcassonnepage = new JFrame();
		carcassonnepage.setSize(width,height);
		
		JPanel panelcarcassonne = new JPanel(new BorderLayout());
		JPanel paneljouer = new JPanel();
		JPanel panelinstru = new JPanel();
		JPanel panelretour = new JPanel();
		JPanel panelquitter = new JPanel();
		JLabel labelhome = new JLabel(new ImageIcon(bg.getImage()));
		JButton jouer = new JButton("Jouer");
		JButton instructions = new JButton("Instructions");
		JButton retour = new JButton("Retour");
		JButton quitter = new JButton("Quitter");
		
	    //enleve l'arrière plan
		jouer.setContentAreaFilled(false);
	    //enlever la bordure
	    jouer.setBorderPainted(false);
	    jouer.setForeground(Color.white);
	    jouer.setFont(new Font("Arial",0,30));
	    
	    
	    instructions.setContentAreaFilled(false);
	    instructions.setBorderPainted(false);
	    instructions.setForeground(Color.white);
	    instructions.setFont(new Font("Arial",0,30));
	    
	    retour.setContentAreaFilled(false);
	    retour.setBorderPainted(false);
	    retour.setForeground(Color.white);
	    retour.setFont(new Font("Arial",0,30));
	    
	    quitter.setContentAreaFilled(false);
	    quitter.setBorderPainted(false);
	    quitter.setForeground(Color.white);
	    quitter.setFont(new Font("Arial",0,30));

		jouer.addActionListener((event) ->{
	    	try {
				InstruGame instru = new InstruGame();
				carcassonnepage.setVisible(false);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    });
	    
	    
	    
	    retour.addActionListener((event) ->{
	    	try {
				HomePage hp = new HomePage();
				carcassonnepage.setVisible(false);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    });

		instructions.addActionListener((event) ->{
	    	try {
				InstructionsCarcassonne id = new InstructionsCarcassonne();
				carcassonnepage.setVisible(false);
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
	    panelcarcassonne.setLayout(new BoxLayout(panelcarcassonne,BoxLayout.PAGE_AXIS));
		
	    
	    panelcarcassonne.setBackground(c);
	    panelcarcassonne.add(paneljouer);
	    panelcarcassonne.add(panelinstru);
	    panelcarcassonne.add(panelretour);
	    panelcarcassonne.add(panelquitter);
	    
	    carcassonnepage.setContentPane(new JPanel() {
	        public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(bg.getImage(), 0, 0, width, height, this);
	        }
	    });
	    carcassonnepage.getContentPane().add(panelcarcassonne);
	    carcassonnepage.setVisible(true);
	    carcassonnepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	
	public static void main(String[] args) throws FileNotFoundException {
		CarcassonnePage hp = new CarcassonnePage();
	}
}

