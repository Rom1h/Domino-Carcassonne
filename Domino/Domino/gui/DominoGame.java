package Domino.gui;

import java.awt.*;

import Domino.gui.DominoGame.Domino;
import Domino.model.*;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MouseInputListener;


public class DominoGame extends JPanel{

		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)dimension.getWidth();
        int height = (int)dimension.getHeight();

		File file = new File("Domino/ressources/grey.jpg");
        String localUrl = file.getPath();
        Background bg = new Background(localUrl);

        public boolean run;
        
        public int sizeDomino = 100;
        public int sizeCorner = 20;
        public int sizeCentralSquare = 60;
        Plateau plateau;
        Player currentPlayer,player1,player2;
  
        LinkedList<Tuile> sac;
        JButton commencer,piocher,passerTour,placerTuile,tournerTuile,retour,rejouer,abandonner;
        public int up0,up1,up2,left0,left1,left2,right0,right1,right2,down0,down1,down2;
		boolean pivot;
		boolean gameOver = false;
		
		JTextArea joueur,nameJ1,nameJ2;
        
		JPanel conteneur;
		int xP1,yP1,xP2,yP2;
		int deP1,deP2;
		int elementSac;
		int scoreP1 = 0;
		int scoreP2 = 0;
        int x,y;
        public DominoGame() throws FileNotFoundException{
        	
     		setLayout(null);
     		conteneur=new JPanel(null);
     		conteneur.setSize(1920, 1080);
     		conteneur.setOpaque(false);
     		add(conteneur);
			//couleur transparente qui servira plus tard
			Color c=new Color(255,255,255,0);
         	
           JFrame dominoGame = new JFrame();
        	plateau=new Plateau(24);
        	sac=new LinkedList<>();
        	Tuile t=new TuileD(sac, 28);

			elementSac = 0;
			for(int i = 0; i<sac.size(); i++){
				if(sac.get(i) != null){
					elementSac++;
				}
			}

			commencer=new JButton("Lancer le dé");
			commencer.setBackground(Color.black);
			commencer.setForeground(Color.WHITE);
			commencer.setFont(new Font("Arial",0,20));

        	piocher=new JButton("Pioche");
			piocher.setBackground(Color.black);
			piocher.setForeground(Color.WHITE);
			piocher.setFont(new Font("Arial",0,20));

        	passerTour=new JButton("Passer Tour");
			passerTour.setBackground(Color.black);
			passerTour.setForeground(Color.WHITE);
			passerTour.setFont(new Font("Arial",0,20));

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

			abandonner=new JButton("Abandonner");
			abandonner.setBackground(Color.gray);
			abandonner.setForeground(Color.WHITE);
			abandonner.setFont(new Font("Arial",0,20));


			piocher.setEnabled(false);
			passerTour.setEnabled(false);
			tournerTuile.setEnabled(false);
			rejouer.setEnabled(false);
			abandonner.setVisible(false);
			joueur =new JTextArea();
			conteneur.add(joueur);
			JMenuBar menuBar=new JMenuBar();
			menuBar.add(commencer);
           	menuBar.add(piocher);
         	menuBar.add(passerTour);
         	menuBar.add(tournerTuile);
			menuBar.add(retour);
			menuBar.add(rejouer);
         	menuBar.setBounds((width/2)-350,0,730,30);
         	conteneur.add(menuBar); 

			JMenuBar abandon=new JMenuBar();
			abandon.setBackground(Color.gray);
			abandon.setBorderPainted(false);
			abandon.add(abandonner);
			abandon.setBounds((width/2)-100,height-200,160,30);
			conteneur.add(abandon);

         	Tuile first=sac.getFirst();
         	sac.removeFirst();
         	Domino d=new Domino((TuileD) first, width/2-50-18, height/3+12,null);
         	System.out.println( (width/2-50-18)+"," +(height/3+12));
			plateau.setTuile(first, 10, 10,null);
			d.moved=false;
			conteneur.repaint();
			conteneur.add(d);

			xP1 = 100;
			yP1 = 50;
			xP2 = width-200;
			yP2 = 50;

			deP1 = (int)(Math.random()*6);
			deP2 = (int)(Math.random()*6);
    		
			commencer.addActionListener((ActionEvent e) -> {
				var j1 = JOptionPane.showInputDialog("Quel est ton nom joueur 1 (8 caractères conseillés)");
				var j2 = JOptionPane.showInputDialog("Quel est ton nom joueur 2 (8 caractères conseillés)");
				player1=new Player(j1);
        		player2=new Player(j2);
				if(deP1 > deP2){
					currentPlayer = player1;
					Graphics g = getGraphics();
					g.setColor(Color.white);
					g.setFont(g.getFont().deriveFont(40f));
					g.drawString(player1.name+" commence", width/3+100, 200);
					g.drawString(player1.name+"est à gauche et "+player2.name+" est à droite.", width/4, 300);
					g.drawString("Si vous ne pouvez plus piocher,cela signifie que", width/4, 600);
					g.drawString("le sac de dominos est vide.", width/4, 650);
					g.drawString("Appuyer sur 'Pioche' pour commencer à jouer.", width/4, 750);
				}
				else{
					currentPlayer = player2;
					Graphics g = getGraphics();
					g.setColor(Color.white);
					g.setFont(g.getFont().deriveFont(40f));
					g.drawString(player2.name+" commence", width/3+100, 200);
					g.drawString(player1.name+" est à gauche et "+player2.name+" est à droite.", width/4, 300);
					g.drawString("Si vous ne pouvez plus piocher,cela signifie que", width/4, 600);
					g.drawString("le sac de dominos est vide.", width/4, 650);
					g.drawString("Appuyer sur 'Pioche' pour commencer à jouer.", width/4, 750);
				}
        	
					pivot = false;
					commencer.setEnabled(false);
					piocher.setEnabled(true);
					passerTour.setEnabled(true);
					tournerTuile.setEnabled(true);
					rejouer.setEnabled(true);
			
		});
			 piocher.addActionListener((ActionEvent e) -> {
				
         		if(currentPlayer.courant==null) {
	            		if(currentPlayer == player1) {
			        		currentPlayer.piocherTuile(sac);
							player1.dominoPlayer(player1.courant);
			        		Domino d1=new Domino((TuileD) player1.courant,xP1,yP1,currentPlayer);
			        		conteneur.repaint();
			        		conteneur.add(d1);
	            		}
						else if(currentPlayer == player2) {
			        		currentPlayer.piocherTuile(sac);
							player2.dominoPlayer(player2.courant);
			        		Domino d1=new Domino((TuileD) player2.courant,xP2,yP2,currentPlayer);
			        		conteneur.repaint();
			        		conteneur.add(d1);
	            		}
	            		elementSac--;
						afficherJoueurCourant();
         		}
				 abandonner.setVisible(true);
					
			});
			 
            tournerTuile.addActionListener((ActionEvent e) -> {		

				Domino d1=Domino.getDominoPlayer(currentPlayer);
				remove(Domino.getDominoPlayer(currentPlayer));
				d1.t.turn();
				conteneur.repaint();	
				conteneur.add(d1);
							
			});
            
            passerTour.addActionListener((ActionEvent e) -> {
				if(currentPlayer == player1){
                    currentPlayer = player2;
                }
                else{
                    currentPlayer = player1;
                }
            	if(!gameOver) {
            		if(!sac.isEmpty()) {
		            	currentPlayer.piocherTuile(sac);
						if(Domino.getDominoPlayer(currentPlayer)!=null) {
							conteneur.remove(Domino.getDominoPlayer(currentPlayer));
							Domino.dominoPlayer.remove(Domino.getDominoPlayer(currentPlayer));
						}
		            	if(currentPlayer == player1) {
		            		currentPlayer.dominoPlayer(player1.courant);
							
			        		Domino d1=new Domino((TuileD) currentPlayer.courant,xP1,yP1,currentPlayer);
			        		conteneur.repaint();
			        		conteneur.add(d1);
							afficherJoueurCourant();
						}
		        		else{
		        			if(player2 instanceof Bot) {
		        				currentPlayer=player2;
								Domino d1=new Domino((Bot)player2);
								conteneur.repaint();
								conteneur.add(d1);
		        			}
		        			else {
				        		Domino d1=new Domino((TuileD) currentPlayer.courant,xP2,yP2,currentPlayer);
				        		conteneur.repaint();
				        		conteneur.add(d1);
								afficherJoueurCourant();
		        			}
						}
		            
            		}
            		else {
	            		currentPlayer=player2;
	            		gameOver=true;
		            	afficherJoueurCourant();
            		}
            	}
            	else {
            		gameOver(getGraphics());
            	}
				
			});
			retour.addActionListener((ActionEvent e) ->{
				try {
					DominoPage dominoP = new DominoPage();
					dominoGame.setVisible(false);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			rejouer.addActionListener((ActionEvent e) ->{
				try {
					dominoGame.setVisible(false);
					DominoGame dominoG = new DominoGame();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			abandonner.addActionListener((ActionEvent e) ->{
				gameOver(getGraphics());
			});
            
			
			dominoGame.add(this);
			dominoGame.setSize(width,height);
			dominoGame.setVisible(true);
			dominoGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
        }

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bg.getImage(), 0, 0, width, height, this);
		}

		public void gameOver(Graphics g){
			
				gameOver = true;
				commencer.setEnabled(false);
				piocher.setEnabled(false);
				passerTour.setEnabled(false);
				tournerTuile.setEnabled(false);
				rejouer.setEnabled(true);
				abandonner.setVisible(false);
				
				if(player1.score > player2.score){
				g.setColor(Color.white);
				g.setFont(g.getFont().deriveFont(40f));
				g.drawString(player1.name+" a gagné la partie ! Score de la partie :"+player1.score+":"+player2.score, (width/2)-300, 200);
				}
				else if(player1.score < player2.score){
				g.setColor(Color.white);
				g.setFont(g.getFont().deriveFont(40f));
				g.drawString(player2.name+" a gagné la partie ! Score de la partie :"+player1.score+":"+player2.score, (width/2)-300, 200);
				}
				else{
				g.setColor(Color.white);
				g.setFont(g.getFont().deriveFont(40f));
				g.drawString("Match nul !", (width/2)-300, 200);
				}
			
		}
		public void afficherJoueurCourant() {
        	if(joueur!=null) {
        		conteneur.remove(joueur);
        	}
        	joueur=new JTextArea("Au tour de "+ currentPlayer.name);
        	joueur.setFont(new Font("Serif", Font.BOLD, 30));
        	joueur.setForeground(Color.white);
        	joueur.setOpaque(false);
        	joueur.setBounds((width/2)-150, 30, 315, 35);
			joueur.setEditable(false);

			nameJ1=new JTextArea(player1.name);
        	nameJ1.setFont(new Font("Serif", Font.BOLD, 20));
        	nameJ1.setForeground(Color.white);
        	nameJ1.setOpaque(false);
        	nameJ1.setBounds(100, 5, 100, 25);
			nameJ1.setEditable(false);

			nameJ2=new JTextArea(player2.name);
        	nameJ2.setFont(new Font("Serif", Font.BOLD, 20));
        	nameJ2.setForeground(Color.white);
        	nameJ2.setOpaque(false);
        	nameJ2.setBounds(width-200, 5, 100, 25);
			nameJ2.setEditable(false);
        	conteneur.add(joueur);
        	conteneur.add(nameJ1);
        	conteneur.add(nameJ2);
        	
        }
        TuileD tuile = new TuileD();
        int u0 = tuile.up[0];
        int u1 = tuile.up[1];
        int u2 = tuile.up[2];

        
        int l0 = tuile.left[0];
        int l1 = tuile.left[1];
        int l2 = tuile.left[2];

        int r0 = tuile.right[0];
        int r1 = tuile.right[1];
        int r2 = tuile.right[2];

        int d0 = tuile.down[0];
        int d1 = tuile.down[1];
        int d2 = tuile.down[2];
        public class Domino extends JComponent implements MouseInputListener, MouseMotionListener{
	        boolean etat;
	        TuileD t;
			int xClick,yClick;
			boolean moved;
			int i,j;
			Player player;
			
			public static LinkedList<Domino> dominoPlayer=new LinkedList<>();
			public Domino(Bot b) {
					b.setTuile(plateau, sac);
					player=b;
					moved=false;
					t=(TuileD)b.t;
					if(b.i!=-1) {
						
						setBounds((b.j-3)*100,(b.i-7)*100,100,100);
						Color c=new Color(255,255,255,0);
						setBackground(c);
						
					}
					else {
						System.out.println("gg");
						setBounds(0, 0, 0, 0);
						
					}
					
				
				
				currentPlayer=player1;
				afficherJoueurCourant();
				//pour avoir un carré transparent en arrière plan du domino

				
			}
	     	Domino(TuileD tuile,int x,int y,Player p){
	     		player=p;
				moved=true;
				t=tuile;
				i=x;
				j=y;		
				setBounds(x,y,100,100);

				//pour avoir un carré transparent en arrière plan du domino
				Color c=new Color(255,255,255,0);
				setBackground(c);
			
				addMouseListener(this);
	            addMouseMotionListener(this);
	            if(p!=null) {
	            	dominoPlayer.add(this);
	            }
	            
	            
	    	}
	     
	     	public static Domino getDominoPlayer(Player p) {
	     		for(Domino d : dominoPlayer) {
	     			if(d.player==p)return d;
	     		}
	     		
	     		return null;
	     	}
	     	public void paintComponent(Graphics g) {
				super.paintComponent(g);
			
				g.setColor(Color.white);
				 g.drawRect(x, y, 100, 100);
	              
				 
				 //draw columns
				  g.drawLine(x, y+20, x+100, y+20);
			      g.drawLine(x, y+40, x+100, y+40);
			      g.drawLine(x, y+60, x+100, y+60);
			      g.drawLine(x, y+80, x+100, y+80);
	
	
			      //draw lines
			      g.drawLine(x+20, y, x+20, y+100);
			      g.drawLine(x+40, y, x+40, y+100);
			      g.drawLine(x+60, y, x+60, y+100);
			      g.drawLine(x+80, y, x+80, y+100);

	
			        //top left corner
			      g.fillRect(x, y, sizeCorner, sizeCorner);
			        //top right corner
			      g.fillRect(x+80, y, sizeCorner, sizeCorner);
			        //bottom left corner
			      g.fillRect(x, y+80, sizeCorner, sizeCorner);
			        //bottom right corner
			      g.fillRect(x+80, y+80, sizeCorner, sizeCorner);
	
			        //central square
			      g.fillRect(x+20, y+20, sizeCentralSquare, sizeCentralSquare);
	
	              //up
	              g.drawString(String.valueOf(t.up[0]), x+28, y+15);
	              g.drawString(String.valueOf(t.up[1]), x+48, y+15);
	              g.drawString(String.valueOf(t.up[2]), x+68, y+15);
	              //left
	              g.drawString(String.valueOf(t.left[0]), x+5, y+35);
	              g.drawString(String.valueOf(t.left[1]), x+5, y+55);
	              g.drawString(String.valueOf(t.left[2]), x+5, y+75);
	              //right
	              g.drawString(String.valueOf(t.right[0]), x+85, y+35);
	              g.drawString(String.valueOf(t.right[1]), x+85, y+55);
	              g.drawString(String.valueOf(t.right[2]), x+85, y+75);
	              //down
	              g.drawString(String.valueOf(t.down[0]), x+28, y+95);
	              g.drawString(String.valueOf(t.down[1]), x+48, y+95);
	              g.drawString(String.valueOf(t.down[2]), x+68, y+95);

				}
	
	    	@Override
	        public void mouseClicked(MouseEvent e) {
	    		if(moved) {
	    		if(!etat) {
	    	
					etat=true;
					xClick=e.getX();
					yClick=e.getY();
					
				}
				else {
					
					int posX=e.getXOnScreen()-e.getXOnScreen()%100;
					int posY=e.getYOnScreen()-e.getYOnScreen()%100;
					int i=posY/100+7;
					int j=posX/100+3;
					if(t.positionValide(plateau, i, j)) {
						plateau.setTuile(t, i, j,currentPlayer);
						setLocation(posX, posY);
						etat=false;
						moved=false;
						dominoPlayer.remove(this);
						currentPlayer.courant=null;
						if(!(player2 instanceof Bot)) {
							if(player==player1) {					
								currentPlayer=player2;
								
							}
							else {
								currentPlayer=player1;
							}
						
						}
						else {
							Domino d1=new Domino((Bot)player2);
							conteneur.repaint();
							conteneur.add(d1);
						}
					}
					else {
						setLocation(this.i, this.j);
						etat=false;
					}
					
					
	    		}
	    		}
	    	}
	    		
	
	
	    @Override
	    public void mouseEntered(MouseEvent arg0) {
	    // TODO Auto-generated method stub
	
	    }
	
	
	    @Override
	    public void mouseExited(MouseEvent arg0) {
	    // TODO Auto-generated method stub
	
	    }
	
	
	    @Override
	    public void mousePressed(MouseEvent arg0) {
	
	    }
	
	
	    @Override
	    public void mouseReleased(MouseEvent arg0) {
	    // TODO Auto-generated method stub
	
	    }
	
	
	    @Override
	    public void mouseDragged(MouseEvent arg0) {
	    // TODO Auto-generated method stub
	
	    }
	
	
	    @Override
	    public void mouseMoved(MouseEvent e) {
	    	if(etat) {
				int x=e.getXOnScreen()-DominoGame.this.getX()-DominoGame.this.getInsets().left-xClick;
				int y=e.getYOnScreen()-DominoGame.this.getY()-DominoGame.this.getInsets().top-yClick;				
				setLocation(x, y);		
			}
	
	    }
	     }
	        public static void main(String[] args) throws FileNotFoundException {
	           DominoGame d=new DominoGame();
	        }

      

}




