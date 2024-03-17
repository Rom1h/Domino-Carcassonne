package Carcassonne.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import Carcassonne.model.PlayerC;
import Carcassonne.model.TuileC;
import Domino.gui.CarcassonnePage;
import Domino.model.Background;
import Domino.model.Plateau;

public class TuileCarcassonne extends JPanel implements MouseInputListener, MouseMotionListener{

    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int)dimension.getWidth();
	int height = (int)dimension.getHeight();


    static BufferedImage tuile,first,gui;
    static JLabel finaltuile;
    static int xClick,yClick,x,y;
    Point currentPos = new Point(width/5,300),newPos;



        public boolean run;
        
        static PlayerC currentPlayer,player1,player2,player3,player4,player5;
  
        LinkedList<TuileC> sac;
        Plateau p;
        public static LinkedList<TuileCarcassonne> carcassonnePlayer=new LinkedList<>();
        JButton commencer,piocher,placerTuile,tournerTuile,retour,rejouer;
		boolean rotate;
		boolean gameOver = false;
		
		JTextArea joueur,partisan,nameJ1,nameJ2,sacVide,endgame;
        TuileC firstTuile;
		JPanel conteneur,plateau;
		int elementSac = 71;
		int scoreP1 = 0;
		int scoreP2 = 0;
        Icon icon;
        int longueur = 8;
        int largeur = 9;
        int nbrdejoueurs = 0;
        int caseplateau = 71;

        public TuileCarcassonne() throws FileNotFoundException{


            JFrame frame = new JFrame();
            frame.setTitle();
            frame.setSize(width,height);

            setLayout(new GridLayout(1,2));
            conteneur=new JPanel(null);
            conteneur.setSize(width, height);
            conteneur.setOpaque(false);
            add(conteneur);


            plateau = new JPanel(new GridLayout(8,9));
     		plateau.setSize(width/2, height/2);
     		plateau.setOpaque(false);
     		add(plateau,BorderLayout.EAST);


            sac=new LinkedList<>();
            TuileC tuilec = new TuileC(sac);
            p=new Plateau(100);

            int rd = (int)(Math.random()*sac.size());
            firstTuile=sac.get(rd);
            first = sac.get(rd).getTuile();
            sac.remove(rd);


            commencer=new JButton("Commencer");
			commencer.setBackground(Color.black);
			commencer.setForeground(Color.WHITE);
			commencer.setFont(new Font("Arial",0,20));

        	piocher=new JButton("Pioche");
			piocher.setBackground(Color.black);
			piocher.setForeground(Color.WHITE);
			piocher.setFont(new Font("Arial",0,20));


			retour= new JButton("Retour");
			retour.setBackground(Color.black);
			retour.setForeground(Color.WHITE);
			retour.setFont(new Font("Arial",0,20));

			rejouer = new JButton("Rejouer");
			rejouer.setBackground(Color.black);
			rejouer.setForeground(Color.WHITE);
			rejouer.setFont(new Font("Arial",0,20));

        	//placerTuile=new JButton("Placer domino");
			tournerTuile=new JButton("Tourner");
			tournerTuile.setBackground(Color.black);
			tournerTuile.setForeground(Color.WHITE);
			tournerTuile.setFont(new Font("Arial",0,20));


			piocher.setEnabled(false);
			tournerTuile.setEnabled(true);
			rejouer.setEnabled(false);
			joueur =new JTextArea();
			conteneur.add(joueur);
			JMenuBar menuBar=new JMenuBar();
			menuBar.add(commencer);
           	menuBar.add(piocher);
         	menuBar.add(tournerTuile);
			menuBar.add(retour);
			menuBar.add(rejouer);
         	menuBar.setBounds(200,0,580,30);
         	conteneur.add(menuBar); 




			commencer.addActionListener((ActionEvent e) -> {
                var nbrjoueur = JOptionPane.showInputDialog("Combien de joueurs jouent ? (2 à 5 joueurs)");
                if(nbrjoueur.equals("2")){
                    nbrdejoueurs = Integer.valueOf(nbrjoueur);
                    var j1 = JOptionPane.showInputDialog("Quel est ton nom joueur 1 (8 caractères conseillés)");
				    var j2 = JOptionPane.showInputDialog("Quel est ton nom joueur 2 (8 caractères conseillés)");
                    player1=new PlayerC(j1);
        		    player2=new PlayerC(j2);
                    currentPlayer = player1;
				    Graphics g = getGraphics();
				    g.setColor(Color.black);
				    g.setFont(g.getFont().deriveFont(30f));
				    g.drawString(player1.name+" commence", 100, 200);
				    g.drawString("Si vous ne pouvez plus piocher,cela signifie que", 100, 300);
				    g.drawString("le sac est vide.", 100, 350);
                    g.drawString(player1.name+" est en rouge", 100, 450);
                    g.drawString(player2.name+" est en bleu", 100, 500);
				    g.drawString("Appuyer sur 'Pioche' pour commencer à jouer.", 100, 800);

                    rotate = false;
				    commencer.setEnabled(false);
				    piocher.setEnabled(true);
				    tournerTuile.setEnabled(true);
				    rejouer.setEnabled(true);
                }
                else if(nbrjoueur.equals("3")){
                    nbrdejoueurs = Integer.valueOf(nbrjoueur);
                    var j1 = JOptionPane.showInputDialog("Quel est ton nom joueur 1 (8 caractères conseillés)");
				    var j2 = JOptionPane.showInputDialog("Quel est ton nom joueur 2 (8 caractères conseillés)");
                    var j3 = JOptionPane.showInputDialog("Quel est ton nom joueur 3 (8 caractères conseillés)");
                    player1=new PlayerC(j1);
        		    player2=new PlayerC(j2);
                    player3=new PlayerC(j3);
                    currentPlayer = player1;
				    Graphics g = getGraphics();
				    g.setColor(Color.black);
				    g.setFont(g.getFont().deriveFont(30f));
				    g.drawString(player1.name+" commence", 100, 200);
				    g.drawString("Si vous ne pouvez plus piocher,cela signifie que", 100, 300);
				    g.drawString("le sac est vide.", 100, 350);
                    g.drawString(player1.name+" est en rouge", 100, 450);
                    g.drawString(player2.name+" est en bleu", 100, 500);
                    g.drawString(player3.name+" est en jaune", 100, 550);
				    g.drawString("Appuyer sur 'Pioche' pour commencer à jouer.", 100, 800);

                    rotate = false;
				    commencer.setEnabled(false);
				    piocher.setEnabled(true);
				    tournerTuile.setEnabled(true);
				    rejouer.setEnabled(true);
                }
                else if(nbrjoueur.equals("4")){
                    nbrdejoueurs = Integer.valueOf(nbrjoueur);
                    var j1 = JOptionPane.showInputDialog("Quel est ton nom joueur 1 (8 caractères conseillés)");
				    var j2 = JOptionPane.showInputDialog("Quel est ton nom joueur 2 (8 caractères conseillés)");
                    var j3 = JOptionPane.showInputDialog("Quel est ton nom joueur 3 (8 caractères conseillés)");
                    var j4 = JOptionPane.showInputDialog("Quel est ton nom joueur 4 (8 caractères conseillés)");
                    player1=new PlayerC(j1);
        		    player2=new PlayerC(j2);
                    player3=new PlayerC(j3);
        		    player4=new PlayerC(j4);
                    currentPlayer = player1;
				    Graphics g = getGraphics();
				    g.setColor(Color.black);
				    g.setFont(g.getFont().deriveFont(30f));
				    g.drawString(player1.name+" commence", 100, 200);
				    g.drawString("Si vous ne pouvez plus piocher,cela signifie que", 100, 300);
				    g.drawString("le sac est vide.", 100, 350);
                    g.drawString(player1.name+" est en rouge", 100, 450);
                    g.drawString(player2.name+" est en bleu", 100, 500);
                    g.drawString(player3.name+" est en jaune", 100, 550);
                    g.drawString(player4.name+" est en rose", 100, 600);
				    g.drawString("Appuyer sur 'Pioche' pour commencer à jouer.", 100, 800);

                    rotate = false;
				    commencer.setEnabled(false);
				    piocher.setEnabled(true);
				    tournerTuile.setEnabled(true);
				    rejouer.setEnabled(true);
                }
                else if(nbrjoueur.equals("5")){
                    nbrdejoueurs = Integer.valueOf(nbrjoueur);
                    var j1 = JOptionPane.showInputDialog("Quel est ton nom joueur 1 (8 caractères conseillés)");
				    var j2 = JOptionPane.showInputDialog("Quel est ton nom joueur 2 (8 caractères conseillés)");
                    var j3 = JOptionPane.showInputDialog("Quel est ton nom joueur 3 (8 caractères conseillés)");
                    var j4 = JOptionPane.showInputDialog("Quel est ton nom joueur 4 (8 caractères conseillés)");
                    var j5 = JOptionPane.showInputDialog("Quel est ton nom joueur 5 (8 caractères conseillés)");
                    player1=new PlayerC(j1);
        		    player2=new PlayerC(j2);
                    player3=new PlayerC(j3);
        		    player4=new PlayerC(j4);
                    player5=new PlayerC(j5);
                    currentPlayer = player1;
				    Graphics g = getGraphics();
				    g.setColor(Color.black);
				    g.setFont(g.getFont().deriveFont(30f));
				    g.drawString(player1.name+" commence", 100, 200);
				    g.drawString("Si vous ne pouvez plus piocher,cela signifie que", 100, 300);
				    g.drawString("le sac est vide.", 100, 350);
                    g.drawString(player1.name+" est en rouge", 100, 450);
                    g.drawString(player2.name+" est en bleu", 100, 500);
                    g.drawString(player3.name+" est en jaune", 100, 550);
                    g.drawString(player4.name+" est en rose", 100, 600);
                    g.drawString(player5.name+" est en violet", 100, 650);
				    g.drawString("Appuyer sur 'Pioche' pour commencer à jouer.", 100, 800);

                    rotate = false;
				    commencer.setEnabled(false);
				    piocher.setEnabled(true);
				    tournerTuile.setEnabled(true);
				    rejouer.setEnabled(true);
                }
                
                player1.color = "Rouge";
                player2.color = "Bleu";
                if(player3!=null) {
                	player3.color = "Jaune";
                }
                if(player4!=null) {
                	player4.color = "Rose";
                }
                if(player5!=null) {
                	player5.color = "Violet";
                }
			
		});

        String [][] tab = new String[longueur][largeur];
        String x = "X" ;

        for(int i = 0; i<longueur; i++){
            for(int j = 0; j<largeur; j++){
                JButton button = new JButton();
                Icon icon1 = new ImageIcon(first);
                if(i == 3 && j == 4){
                	p.setTuile(firstTuile, i+47, j+46,(PlayerC) null);
                	firstTuile.afficherRoute();
                    button.setEnabled(false);
                    button.setIcon(icon1);
                    button.setDisabledIcon(button.getIcon());
                }
                button.setName(i+","+j);
                button.setBackground(Color.white);
                tab[3][4] = x;
                
                button.addActionListener((event) ->{
                    currentPlayer.courant.afficherRoute();
                    
                    
                	if(currentPlayer.courant.positionValide(p,(Character.getNumericValue(button.getName().charAt(0))+47),(Character.getNumericValue(button.getName().charAt(2))+46))) {
                		
                	p.setTuile(currentPlayer.courant,Character.getNumericValue(button.getName().charAt(0))+47,Character.getNumericValue(button.getName().charAt(2))+46 , currentPlayer);
                	 
                    //permet de compter le nombre de cases qui ont été cliquée
                     if(caseplateau > 0){
                        caseplateau--;
                        gameOver();
                     }

                	if(currentPlayer.pion > 0){
                        var meeple = JOptionPane.showInputDialog("Veux tu placer un partisan ? (Oui/Non)");
                    if(meeple.equals("oui") || meeple.equals("Oui")){
                        try {
                            Icon meepleJ = new ImageIcon(colorMeeple(tuile));
                            button.setIcon(meepleJ);
                            button.setDisabledIcon(button.getIcon());//permet de voir la tuile en couleur même si le bouton est désactivé
                            nextPlayer();
                            nextPlayerTuile();
                            } catch (FileNotFoundException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                    else if(meeple.equals("non") || meeple.equals("Non")){
                        try {
                            button.setIcon(icon);
                            button.setEnabled(false);
                            button.setDisabledIcon(button.getIcon());//permet de voir la tuile en couleur même si le bouton est désactivé
                            nextPlayer();
                            nextPlayerTuile();
                        } catch (FileNotFoundException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                            }
                        }
                    }
                    else{
                        try{
                            button.setIcon(icon);
                            button.setEnabled(false);
                            button.setDisabledIcon(button.getIcon());//permet de voir la tuile en couleur même si le bouton est désactivé
                            nextPlayer();
                            nextPlayerTuile();
                        }
                         catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        }
                        button.setEnabled(false);
                        button.setDisabledIcon(button.getIcon());//permet de voir la tuile en couleur même si le bouton est désactivé

                    }
                	
                	}
                    afficherJoueurCourant();
                });
                plateau.add(button);
            }
        }

			 piocher.addActionListener((ActionEvent e) -> {
         		if(currentPlayer.courant==null) {
	            	try {
                        NouvelleTuilePlayer();
                        if(elementSac > 0){
                            elementSac--;
                        }
                        afficherJoueurCourant();
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
         		}
                else if(currentPlayer.courant != null){
                    try {
                        NouvelleTuilePlayer();
                        afficherJoueurCourant();
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                afficherJoueurCourant();
					
			});
			 
            tournerTuile.addActionListener((ActionEvent e) -> {		
                rotate = true;
                tuile = rotateImage();
                gui = rotateImageGUI();
                currentPlayer.courant.turn();
                repaint();
                icon = new ImageIcon(tuile);
			});
            

			retour.addActionListener((ActionEvent e) ->{
				try {
					CarcassonnePage dominoP = new CarcassonnePage();
					frame.dispose();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			rejouer.addActionListener((ActionEvent e) ->{
                try {
                    frame.setVisible(false);
                    TuileCarcassonne carcassonne = new TuileCarcassonne();
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
			});

            frame.add(this);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        public void TuilePlayer() throws FileNotFoundException{
        	currentPlayer.piocherTuile(sac);
            currentPlayer.carcassonnePlayer(currentPlayer.courant);
            tuile = currentPlayer.getTuilePlayer().getTuile();
            gui = tuile;
            gui = scale(tuile,1.5f);
            icon = new ImageIcon(tuile);
            finaltuile = new JLabel(new ImageIcon(tuile));
            conteneur.repaint();
            conteneur.add(finaltuile);
            elementSac--;
        }

        //quand le joueur pioche parce qu'il ne peut pas placer son pion
        public void NouvelleTuilePlayer() throws FileNotFoundException{
        	currentPlayer.piocherNouvelleTuile(sac);
            currentPlayer.carcassonnePlayer(currentPlayer.courant);
            tuile = player1.getTuilePlayer().getTuile();
            gui = tuile;
            gui = scale(tuile,1.5f);
            icon = new ImageIcon(tuile);
            finaltuile = new JLabel(new ImageIcon(tuile));
            conteneur.repaint();
            conteneur.add(finaltuile);
        }

        public void nextPlayer(){
            if(nbrdejoueurs == 2){
                if(currentPlayer == player1){
                    currentPlayer = player2;
                }
                else{currentPlayer = player1;}
            }
            if(nbrdejoueurs == 3){
                if(currentPlayer == player1){
                    currentPlayer = player2;
                }
                else if(currentPlayer == player2){ currentPlayer = player3;}
                else{currentPlayer = player1;}
            }
            if(nbrdejoueurs == 4){
                if(currentPlayer == player1){
                    currentPlayer = player2;
                }
                else if(currentPlayer == player2){ currentPlayer = player3;}
                else if(currentPlayer == player3){currentPlayer = player4;}
                else{currentPlayer = player1;}
            }
            if(nbrdejoueurs == 5){
                if(currentPlayer == player1){
                    currentPlayer = player2;
                }
                else if(currentPlayer == player2){ currentPlayer = player3;}
                else if(currentPlayer == player3){currentPlayer = player4;}
                else if(currentPlayer == player4){currentPlayer = player5;}
                else{currentPlayer = player1;}
            }
        }

        

        public void nextPlayerTuile() throws FileNotFoundException{
            currentPlayer.piocherTuile(sac);
            tuile = currentPlayer.getTuilePlayer().getTuile();
            gui = tuile;
            gui = scale(tuile,1.5f);
            icon = new ImageIcon(tuile);
            finaltuile = new JLabel(new ImageIcon(tuile));
            currentPlayer.carcassonnePlayer(currentPlayer.courant);
    
            conteneur.repaint();
            conteneur.add(finaltuile);
            elementSac--;
            afficherJoueurCourant();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(gui, currentPos.x, currentPos.y, this);
            if(gameOver == true){
                g.setColor(Color.black);
                g.fillRect(50,50, (width/2)-100, 850);
            }
        }

        public void actionPerformed(ActionEvent arg0) {
            System.out.println(((JButton)(arg0.getSource())).getName());//permet de savoir quel bouton a été appellé
        }

        public void afficherJoueurCourant() {
        	if(joueur!=null) {
        		conteneur.remove(joueur);
        	}
            if(currentPlayer.pion > 1){
                joueur=new JTextArea("Au tour de "+ currentPlayer.name+" ("+currentPlayer.color+")"+"\n\n\n\n\n\n\n\n\n\n\n\nIl te reste "+currentPlayer.pion+" partisans");
                joueur.setFont(new Font("Serif", Font.BOLD, 30));
                joueur.setForeground(Color.black);
                joueur.setOpaque(false);
                joueur.setBounds(width/6-50, 200, 500, 1000);
                joueur.setEditable(false);
                conteneur.add(joueur);
            }
            else if(currentPlayer.pion <= 1){
                joueur=new JTextArea("Au tour de "+ currentPlayer.name+" ("+currentPlayer.color+")"+"\n\n\n\n\n\n\n\n\n\n\n\nIl te reste "+currentPlayer.pion+" partisan");
                joueur.setFont(new Font("Serif", Font.BOLD, 30));
                joueur.setForeground(Color.black);
                joueur.setOpaque(false);
                joueur.setBounds(width/6-50, 200, 500, 1000);
                joueur.setEditable(false);
                conteneur.add(joueur);
            }
            //pour afficher si le sac est vide
            if(elementSac == 0){
                sacVide=new JTextArea("Le sac est vide");
                sacVide.setFont(new Font("Serif", Font.BOLD, 30));
                sacVide.setForeground(Color.black);
                sacVide.setOpaque(false);
                sacVide.setBounds(width/6, 80, 500, 35);
                sacVide.setEditable(false);
                repaint();
                conteneur.add(sacVide);
            }
        	
        }

        public static BufferedImage scale(BufferedImage bi, float scaleValue) {
            AffineTransform tx = new AffineTransform();
            tx.scale(scaleValue, scaleValue);
            AffineTransformOp op = new AffineTransformOp(tx,
                    AffineTransformOp.TYPE_BILINEAR);
            BufferedImage biNew = new BufferedImage( (int) (bi.getWidth() * scaleValue),
                    (int) (bi.getHeight() * scaleValue),
                    bi.getType());
            return op.filter(bi, biNew);
        }

        public static BufferedImage colorMeeple(BufferedImage image) throws FileNotFoundException{
            var position = JOptionPane.showInputDialog("Ou veux tu le placer ? (Taper haut, centre, bas, gauche ou droite)");
            Background Meeple = null;;

            if(currentPlayer == player1){File file = new File("Carcassonne/ressources/RedMeeple.png");String localUrl = file.getPath();Meeple = new Background(localUrl);}
            if(currentPlayer == player2){File file = new File("Carcassonne/ressources/BlueMeeple.png");String localUrl = file.getPath();Meeple = new Background(localUrl);}
            if(currentPlayer == player3){File file = new File("Carcassonne/ressources/YellowMeeple.png");String localUrl = file.getPath();Meeple = new Background(localUrl);}
            if(currentPlayer == player4){File file = new File("Carcassonne/ressources/PinkMeeple.png");String localUrl = file.getPath();Meeple = new Background(localUrl);}
            if(currentPlayer == player5){File file = new File("Carcassonne/ressources/PurpleMeeple.png");String localUrl = file.getPath();Meeple = new Background(localUrl);}


            int widthOfImage = image.getWidth();
            int heightOfImage = image.getHeight();
            int typeOfImage = image.getType();
    
            BufferedImage newImage = new BufferedImage(widthOfImage, heightOfImage, typeOfImage);
    
            Graphics2D graphics2D = newImage.createGraphics();

            if(position.equals("haut") || position.equals("Haut")){
                graphics2D.drawImage(image, null, 0, 0);
                graphics2D.drawImage(Meeple.getImage(), null, (widthOfImage/2)-10, 0);
            }
            else if(position.equals("bas") || position.equals("Bas")){
                graphics2D.drawImage(image, null, 0, 0);
                graphics2D.drawImage(Meeple.getImage(), null, (widthOfImage/2)-10, heightOfImage-20);
            }
            else if(position.equals("gauche") || position.equals("Gauche")){
                graphics2D.drawImage(image, null, 0, 0);
                graphics2D.drawImage(Meeple.getImage(), null, 0, (heightOfImage/2)-10);
            }
            else if(position.equals("droite") || position.equals("Droite")){
                graphics2D.drawImage(image, null, 0, 0);
                graphics2D.drawImage(Meeple.getImage(), null, widthOfImage-20, (heightOfImage/2)-10);
            }
            else if(position.equals("centre") || position.equals("Centre")){
                graphics2D.drawImage(image, null, 0, 0);
                graphics2D.drawImage(Meeple.getImage(), null, (widthOfImage/2)-10, (heightOfImage/2)-10);
            }
    
            currentPlayer.removePion();
            return newImage;

        }


        public static BufferedImage rotateImage() {
            int widthOfImage = tuile.getWidth();
            int heightOfImage = tuile.getHeight();
            int typeOfImage = tuile.getType();
    
            BufferedImage newImage = new BufferedImage(widthOfImage, heightOfImage, typeOfImage);
    
            Graphics2D graphics2D = newImage.createGraphics();
    
            graphics2D.rotate(Math.toRadians(90), widthOfImage/2, heightOfImage/2);
            graphics2D.drawImage(tuile, null, 0, 0);
    
            return newImage;
        }

        public static BufferedImage rotateImageGUI() {
            int widthOfImage = gui.getWidth();
            int heightOfImage = gui.getHeight();
            int typeOfImage = gui.getType();
    
            BufferedImage newImage = new BufferedImage(widthOfImage, heightOfImage, typeOfImage);
    
            Graphics2D graphics2D = newImage.createGraphics();
    
            graphics2D.rotate(Math.toRadians(90), widthOfImage/2, heightOfImage/2);
            graphics2D.drawImage(gui, null, 0, 0);
    
            return newImage;
        }


        public void gameOver(){


			if(caseplateau == 0){
                gameOver = true;
                commencer.setEnabled(false);
                piocher.setEnabled(false);
                tournerTuile.setEnabled(false);

                endgame=new JTextArea("La partie est terminée !\nAppuyer sur 'Rejouer' pour relancer une partie.");
                endgame.setFont(new Font("Serif", Font.BOLD, 30));
                endgame.setForeground(Color.white);
                endgame.setOpaque(false);
                endgame.setBounds(90, 400, (width/2)-100, 500);
                endgame.setEditable(false);
                repaint();
                conteneur.add(endgame);

                
            }
        }
        


        public static TuileCarcassonne getCarcassonnePlayer(PlayerC p) {
            for(TuileCarcassonne tuile : carcassonnePlayer) {
                if(tuile.currentPlayer == p)return tuile;
            }
            
            return null;
        }

    
    public static void main(String[] args) throws FileNotFoundException{
        TuileCarcassonne tuileC = new TuileCarcassonne();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        xClick = e.getX();
        yClick = e.getY();
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    }
