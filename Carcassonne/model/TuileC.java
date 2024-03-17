package Carcassonne.model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import Carcassonne.model.Paysage.Direction;
import Domino.model.Background;
import Domino.model.Plateau;
import Domino.model.Tuile;


public class TuileC extends Tuile {
	boolean[] route ;//route[0] :indique le nord ,route[1] :indique l'est ,route[2] :
	String image;					//indique le sud, route[3] :indique l'ouest
	Paysage[] paysage;//paysage[0] :coin haut gauche,paysage[1] :coin haut droite,paysage[2] :coin bas gauche,
						//paysage[2] :coin bas droit,
	BufferedImage tuile;					
	
	public TuileC(LinkedList<TuileC> sac){
		for(int i=0;i<9;i++) {
			boolean[] b= {false,false,true,true};
			Paysage[] p= {new Prairie(),new Prairie(),new Prairie(),new Prairie()};
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 24.png"));
		}
		
		for(int i=0;i<3;i++) {
			boolean[] b= {false,true,true,false};
			Paysage[] p= {new Ville(Direction.NORD),new Ville(Direction.NORD),new Prairie(),new Prairie()};
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 18.png"));
		}
		
		for(int i=0;i<5;i++) {
			boolean[] b= {false,true,true,false};
			Paysage[] p= {new Ville(Direction.NORD,Direction.OUEST),new Ville(Direction.NORD),new Prairie(),new Ville(Direction.OUEST)};
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 11.png"));
		}

		
		for(int i = 0; i<3; i++){
			boolean[] b1= {false,false,true,false};	
			Paysage[] p1= {new Ville(Direction.NORD,Direction.OUEST),new Ville(Direction.NORD,Direction.EST),new Ville(Direction.EST),new Ville(Direction.OUEST)};		
			sac.add(new TuileC(b1,p1,"Carcassonne/ressources/Tuile 6.png"));
		}

		for(int i = 0; i<3; i++){
			boolean[] b1= {false,false,false,false};	
			Paysage[] p1= {new Ville(Direction.OUEST),new Ville(Direction.EST),new Ville(Direction.OUEST),new Ville(Direction.EST)};		
			sac.add(new TuileC(b1,p1,"Carcassonne/ressources/Tuile 6.png"));
		}



		
		for(int i=0;i<3;i++) {
			boolean[] b= {false,true,true,true};
			Paysage[] p= {new Ville(Direction.NORD),new Ville(Direction.NORD),new Prairie(),new Prairie()};
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 17.png"));
		}
		
		for(int i=0;i<8;i++) {
			boolean[] b= {true,false,true,false};
			Paysage[] p= {new Prairie(),new Prairie(),new Prairie(),new Prairie()};
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 23.png"));
		}
		
		for(int i=0;i<4;i++) {
			boolean[] b= {false,true,true,true};
			Paysage[] p= {new Prairie(),new Prairie(),new Prairie(),new Prairie()};
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 22.png"));
		}
		
		for(int i=0;i<5;i++) {
			boolean[] b= {false,false,false,false};
			Paysage[] p= {new Ville(Direction.NORD),new Ville(Direction.NORD),new Prairie(),new Prairie()};
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 16.png"));
		}
		
		for(int i=0;i<2;i++) {
			boolean[] b= {false,false,false,false};
			Paysage[] p= {new Ville(Direction.NORD),new Ville(Direction.NORD,Direction.EST),new Ville(Direction.EST),new Prairie()};
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 10.png"));
		}
		
		
		for(int i=0;i<4;i++) {
			boolean[] b= {false,false,false,false};	
			Paysage[] p= {new Ville(Direction.NORD,Direction.OUEST),new Ville(Direction.NORD,Direction.EST),new Ville(Direction.EST),new Ville(Direction.OUEST)};		
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 4.png"));
		}
		
		for(int i=0;i<4;i++) {
			boolean[] b= {false,false,false,false};	
			Paysage[] p= {new Prairie(),new Prairie(),new Prairie(),new Prairie()};
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 3.png"));
		}
		
		for(int i=0;i<2;i++) {
			boolean[] b= {false,false,true,false};	
			Paysage[] p= {new Prairie(),new Prairie(),new Prairie(),new Prairie()};
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 2.png"));
		}
		
		for(int i=0;i<5;i++) {
			boolean[] b= {false,false,false,false};
			Paysage[] p= {new Ville(Direction.NORD,Direction.OUEST),new Ville(Direction.NORD),new Prairie(),new Ville(Direction.OUEST)};
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 8.png"));
		}

		
		for(int i=0;i<3;i++) {
			boolean[] b= {false,false,false,false};
			Paysage[] p= {new Ville(Direction.OUEST),new Ville(Direction.EST),new Ville(Direction.EST),new Ville(Direction.OUEST)};
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 13.png"));
		}

		
		for(int i=0;i<4;i++) {
			boolean[] b= {false,true,false,true};
			Paysage[] p= {new Ville(Direction.NORD),new Ville(Direction.NORD),new Prairie(),new Prairie()};
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 20.png"));
		}
		
		for(int i=0;i<3;i++) {
			boolean[] b= {false,false,true,true};
			Paysage[] p= {new Ville(Direction.NORD),new Ville(Direction.NORD),new Prairie(),new Prairie()};
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 19.png"));
		}
		
		for(int i=0;i<1;i++) {
			boolean[] b= {false,false,false,false};
			Paysage[] p= {new Ville(Direction.NORD,Direction.OUEST),new Ville(Direction.NORD,Direction.EST),new Ville(Direction.SUD,Direction.EST),new Ville(Direction.SUD,Direction.OUEST)};
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 1.png"));
		}
		
		for(int i=0;i<1;i++) {
			boolean[] b= {true,true,true,true};
			Paysage[] p= {new Prairie(),new Prairie(),new Prairie(),new Prairie()};
			sac.add(new TuileC(b,p,"Carcassonne/ressources/Tuile 21.png"));
		}

	}
	
	
	TuileC(boolean[] route,Paysage[] paysage,String image){
		this.route=route;
		this.paysage=paysage;
		this.image = image;
	}

	public BufferedImage getTuile() throws FileNotFoundException{
		File file = new File(image);
	    String localUrl = file.getPath();
        Background bg = new Background(localUrl);
        return tuile = bg.getImage();
	}
	public void afficherRoute() {
		for(int i=0;i<=3;i++) {
			System.out.println(route[i]);
			
		}
	}
	public boolean positionValide(Plateau p, int i, int j) {
		if(p.estLibre(i, j) == true) {
			if(p.checkTuile(i, j)&&positionUpValide((TuileC)p.plateau[i+1][j])&& positionDownValide((TuileC)p.plateau[i-1][j])
					&& positionRightValide((TuileC)p.plateau[i][j-1]) && positionLeftValide((TuileC)p.plateau[i][j+1])) {
					return true;
				
				}
		}
		else if(p.estLibre(i, j) == false) {
			
			return false;
		}

		return false;
	}
	
	public boolean positionUpValide(TuileC t) {
		if(t==null) {return true;
		
		}
		if(t.route[0]==false&&route[2]==true||t.route[0]==true&&route[2]==false)return false;
		else if(t.route[0]&&route[2]) {
			return true;
		}
		else {
			if(paysage[2].equals(t.paysage[1])) {
				if(paysage[2].type=='v') {
					if(!((Ville)paysage[2]).dirValide(((Ville)t.paysage[1]))) {
					
						return false;
					}
				}
			}
			else {
				if(Paysage.valide(paysage[2], t.paysage[1], Direction.SUD,Direction.NORD)) {
				
					return false;
				}
			}
			if(paysage[3].equals(t.paysage[0])) {
				if(paysage[3].type=='v') {
					if(!((Ville)paysage[3]).dirValide(((Ville)t.paysage[0]))) {
						((Ville)paysage[3]).affiche();
						
						((Ville)t.paysage[0]).affiche();
						return false;
					}
				}
			}
			else {
				if(Paysage.valide(paysage[3], t.paysage[0], Direction.SUD,Direction.NORD)) {
				
					return false;
				}
			}
			return true;
		}
			
	}
	public boolean positionDownValide(TuileC t) {
		if(t==null){return true;
		
		}
		if(t.route[2]==false&&route[0]==true||t.route[2]==true&&route[0]==false)return false;
		else if(t.route[2]&&route[0]) {
			return true;
		}
		else {
			if(paysage[0].equals(t.paysage[3])) {
				
				if(paysage[0].type=='v') {
					if(!((Ville)paysage[0]).dirValide(((Ville)t.paysage[3]))) {
						return false;
					}
				}
			}
			else {
				if(Paysage.valide(paysage[0], t.paysage[3], Direction.NORD,Direction.SUD)) {
			
					return false;
				}
			}
			if(paysage[1].equals(t.paysage[2])) {

				if(paysage[1].type=='v') {
					if(!((Ville)paysage[1]).dirValide(((Ville)t.paysage[2]))) {
						return false;
					}
				}
			}
			else {
				if(Paysage.valide(paysage[1], t.paysage[2], Direction.NORD,Direction.SUD)) {
					return false;
				}
			}
			return true;
		}
			
	}
	public boolean positionLeftValide(TuileC t) {
		if(t==null){return true;
		
		}
		if((route[1]==false&&t.route[3]==true)||(route[1]==true&&t.route[3]==false)) {
				return false;
		}
		else if(t.route[3]&&route[1])return true;
		else {
			if(paysage[1].equals(t.paysage[0])) {
				if(paysage[1].type=='v') {
					if(!((Ville)paysage[1]).dirValide(((Ville)t.paysage[0]))) {
						
						return false;
					}
				}
			}
			else {
				if(!(paysage[1].equals(t.paysage[0]))&&Paysage.valide(paysage[1], t.paysage[0], Direction.EST,Direction.OUEST)) {
				
					return false;
				}
			}
			if(paysage[2].equals(t.paysage[3])) {
				
				if(paysage[2].type=='v') {
				
					if(!((Ville)paysage[2]).dirValide(((Ville)t.paysage[3]))) {
		
						return false;
					}
				}
			}
			else {
				if(!(paysage[1].equals(t.paysage[0]))&&Paysage.valide(paysage[2], t.paysage[3], Direction.EST,Direction.OUEST)) {
					return false;
				}
			}
			
			return true;
		}
			
	}
	
	public boolean positionRightValide(TuileC t) {
		if(t==null){return true;
		
		}
		if(t.route[1]==false&&route[3]==true||t.route[1]==true&&route[3]==false) {
			return false;
		}
		else if(t.route[1]&&route[3]) {
			return true;
		}
		else {
			if(paysage[0].equals(t.paysage[1])) {
				if(paysage[0].type=='v') {
					if(!((Ville)paysage[0]).dirValide(((Ville)t.paysage[1]))) {
					
						return false;
					}
				}
			}
			else {
				if(Paysage.valide(paysage[0], t.paysage[1], Direction.OUEST,Direction.EST)) {
					
					return false;
				}
			}
			if(paysage[3].equals(t.paysage[2])) {
				if(paysage[3].type=='v') {
					if(!((Ville)paysage[3]).dirValide(((Ville)t.paysage[2]))) {
						return false;
					}
				}
			}
			else {
				if(Paysage.valide(paysage[3], t.paysage[2], Direction.OUEST,Direction.EST)) {
					return false;
				}
			}
			return true;
		}
	}


	@Override
	public void turn() {
		//on tourne les routes
		boolean b=route[3];
		for(int i=3;i>0;i--) {
			route[i]=route[i-1];
		}
		route[0]=b;
		Paysage p=paysage[3];
		for(int i=3;i>0;i--) {
			paysage[i-1].turn();
			paysage[i]=paysage[i-1];
		}
		p.turn();
		paysage[0]=p;
		
		
	}
	
}
