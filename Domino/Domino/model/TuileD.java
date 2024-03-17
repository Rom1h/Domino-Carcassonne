package Domino.model;

import java.util.LinkedList;

public class TuileD extends Tuile {
		public int [] up;
		public int [] left;
		public int [] right;
		public int [] down;
		public enum Face{
			UP,LEFT,DOWN,RIGHT;
		}
		public int getUp(int i) {
			return up[i];
		}
		public TuileD(TuileD t) {
			up = new int[3];
			left = new int[3];
			right = new int[3];
			down = new int[3];
			//random number >= 0 and <10
	        for(int i = 0; i<up.length; i++) {
	        	up[i] = t.up[i];
	        }
	        for(int i = 0; i<left.length; i++) {
	        	
	        	left[i] = t.left[i];
	        }
	        for(int i = 0; i<right.length; i++) {
	        	
	        	right[i] = t.right[i];
	        }
	        for(int i = 0; i<down.length; i++) {
	       
	        	down[i] = t.down[i];
	        }
		}
		public TuileD() {
			up = new int[3];
			left = new int[3];
			right = new int[3];
			down = new int[3];
			//random number >= 0 and <10
	        for(int i = 0; i<up.length; i++) {
	        	int random = (int)(Math.random() * 3);
	        	up[i] = random;
	        }
	        for(int i = 0; i<left.length; i++) {
	        	int random = (int)(Math.random() * 3);
	        	left[i] = random;
	        }
	        for(int i = 0; i<right.length; i++) {
	        	int random = (int)(Math.random() * 3);
	        	right[i] = random;
	        }
	        for(int i = 0; i<down.length; i++) {
	        	int random = (int)(Math.random() * 3);
	        	down[i] = random;
	        }
		}
		//constructeur pour placer deux tuiles qui auront au moin une face egale dans le sac;
		public TuileD(LinkedList<Tuile> sac,int n) {
			up = new int[3];
			left = new int[3];
			right = new int[3];
			down = new int[3];
			//random number >= 0 and <10
	        for(int i = 0; i<up.length; i++) {
	        	int random = (int)(Math.random() * 3);
	        	up[i] = random;
	        }
	        for(int i = 0; i<left.length; i++) {
	        	int random = (int)(Math.random() * 3);
	        	left[i] = random;
	        }
	        for(int i = 0; i<right.length; i++) {
	        	int random = (int)(Math.random() * 3);
	        	right[i] = random;
	        }
	        for(int i = 0; i<down.length; i++) {
	        	int random = (int)(Math.random() * 3);
	        	down[i] = random;
	        }
	        sac.add(this);
	        
	        TuileD t =generateDouble(sac);
	        sac.add(t);
	        for(int i=0;i<n-2;i++) {
	        	
	        	t=t.generateDouble(sac);
	        	sac.add(t);
			}
	        
		}
		
		public TuileD generateDouble(LinkedList<Tuile> sac) {
			return new TuileD() {
				
				int faceEgale=2+(int)(Math.random()*1);//nombre de face qui auront des éléments similaires
				TuileD tmp=new TuileD();
				
				public TuileD generateDouble() {
					
					switch (faceEgale) {
					case 2:{
						tmp=generateTuile(2);
						break;
					}
					case 3:
						tmp=generateTuile(3);
						break;
				}
					return tmp;
					
					
				}
				public boolean isIn(int[] tab,int n) {
					for(int i=0;i<tab.length;i++) {
						if(tab[i]==n)return true;
					}
					return false;
				}
				public TuileD getRandomDomino() {
					
					return (TuileD)sac.get((int)(Math.random()*sac.size()));
				}
				public TuileD generateTuile(int rand) {
					int[] tab=new int[rand];
					
					for(int i=0;i<rand;i++) {
						int n=1+(int)(Math.random()*4);
						while(isIn(tab,n)) {
							n=1+(int)(Math.random()*4);
						}
						tab[i]=n;
					}
					
					for(int i=0;i<rand;i++) {

						switch (tab[i]) {
						case 1: {
							
							createFace(Face.UP,getRandomFace(),getRandomDomino());
							break;
						}
						case 2: {
							
							createFace(Face.RIGHT,getRandomFace(),getRandomDomino());
							break;
						}
						case 3: {
							createFace(Face.DOWN,getRandomFace(),getRandomDomino());
							break;
						}
						case 4:
							createFace(Face.LEFT,getRandomFace(),getRandomDomino());
					}
					}
					return tmp;
				}
				public void createFace(Face f1,Face f2,TuileD t ) {	
					if(f1==Face.UP) {
						switch (f2) {
						case UP: {
							tmp.up[0]=t.up[2];
							tmp.up[1]=t.up[1];
							tmp.up[2]=t.up[0];	
							break;
						}
						case DOWN :{
							tmp.up[0]=t.down[0];
							tmp.up[1]=t.down[1];
							tmp.up[2]=t.down[2];	
							break;
						}
						case LEFT:{
							tmp.up[0]=t.left[0];
							tmp.up[1]=t.left[1];
							tmp.up[2]=t.left[2];	
							break;
						}
						case RIGHT :{
							tmp.up[0]=t.right[2];
							tmp.up[1]=t.right[1];
							tmp.up[2]=t.right[0];	
						}
					}
					}
					else if(f1==Face.DOWN) {
						switch (f2) {
						case UP :{
							tmp.down[0]=t.up[0];
							tmp.down[1]=t.up[1];
							tmp.down[2]=t.up[2];	
							break;
						}
						case DOWN: {
							tmp.down[0]=t.down[2];
							tmp.down[1]=t.down[1];
							tmp.down[2]=t.down[0];	
							break;
						}
						case LEFT:{
							tmp.down[0]=t.left[2];
							tmp.down[1]=t.left[1];
							tmp.down[2]=t.left[0];	
							break;
						}
						case RIGHT :{
							tmp.down[0]=t.right[0];
							tmp.down[1]=t.right[1];
							tmp.down[2]=t.right[2];	
						}
					}
					}
					else if(f1==Face.LEFT) {
						switch (f2) {
						case UP: {
							tmp.left[0]=t.up[0];
							tmp.left[1]=t.up[1];
							tmp.left[2]=t.up[2];	
							break;
						}
						case DOWN :{
							tmp.left[0]=t.down[2];
							tmp.left[1]=t.down[1];
							tmp.left[2]=t.down[0];	
							break;
						}
						case LEFT:{
							tmp.left[0]=t.left[2];
							tmp.left[1]=t.left[1];
							tmp.left[2]=t.left[0];	
							break;
						}
						case RIGHT :{
							tmp.left[0]=t.right[0];
							tmp.left[1]=t.right[1];
							tmp.left[2]=t.right[2];	
						}
					}
					}
					
					else{
						switch (f2) {
						case UP: {
							tmp.right[0]=t.up[2];
							tmp.right[1]=t.up[1];
							tmp.right[2]=t.up[0];	
							break;
						}
						case DOWN :{
							tmp.right[0]=t.down[0];
							tmp.right[1]=t.down[1];
							tmp.right[2]=t.down[2];	
							break;
						}
						case LEFT:{
							tmp.right[0]=t.left[0];
							tmp.right[1]=t.left[1];
							tmp.right[2]=t.left[2];	
							break;
						}
						case RIGHT :{
							tmp.right[0]=t.right[2];
							tmp.right[1]=t.right[1];
							tmp.right[2]=t.right[0];	
						}
						}
					}
				}
				public Face getRandomFace() {
					int rd=(int)(Math.random()*4);
					switch (rd) {
					case 0: 
						return Face.UP;
						
					case 1:
						return	Face.DOWN;
						
					case 2:
						return Face.LEFT;
					
					case 3:
						return Face.RIGHT;
								
					}
					return null;
				}
			
			
			}.generateDouble();		
		}
		public TuileD setTuile(TuileD t) {
			TuileD res=new TuileD();
			res.up=t.up;
			res.down=t.down;
			res.left=t.left;
			res.right=t.right;
			return res;
		}
		
		public void show() {
			System.out.print(" "+up[0]+" "+up[1]+" "+up[2]);
			System.out.println();
			System.out.println(left[0]+"     "+right[0]);
			System.out.println(left[1]+"     "+right[1]);
			System.out.println(left[2]+"     "+right[2]);
			System.out.print(" "+down[0]+" "+down[1]+" "+down[2]);
			System.out.println();
		}
		
		//fonction qui verifie si pour i on a au moin tab[i] =tab1[i]
		public boolean verify(int[] tab,int[] tab1) {
			for(int i=0;i<tab.length;i++) {
				if(tab[i]==tab1[i])return true;
			}
			return false;
		}
		//verifie si on peut place une tuile au dessus de t;
		public boolean positionUpValide(TuileD t) {
			if(t==null)return true ;
			for(int i=0;i<3;i++) {
				if(down[i]!=t.up[i])return false;
			}
			
			 return true;
		}
		public boolean positionDownValide(TuileD t) {
			if(t==null)return true;
			for(int i=0;i<3;i++) {
				if(up[i]!=t.down[i])return false;
			}
			return true;
		}
		public boolean positionLeftValide(TuileD t) {
			if(t==null)return true;
			for(int i=0;i<3;i++) {
				if(right[i]!=t.left[i])return false;
			}
			return true;
		}
		
		public boolean positionRightValide(TuileD t) {
			if(t==null)return true;
			for(int i=0;i<3;i++) {
				if(left[i]!=t.right[i])return false;
				
			}
			return true;
		}
		@Override
		public boolean positionValide(Plateau p, int i, int j) {
			if(p.estLibre(i, j) == true) {
				if(p.checkTuile(i, j)&&positionUpValide((TuileD)p.plateau[i+1][j])&& positionDownValide((TuileD)p.plateau[i-1][j])
						&& positionRightValide((TuileD)p.plateau[i][j-1]) && positionLeftValide((TuileD)p.plateau[i][j+1])) {
						return true;
					
					}
					
				
			}
			else if(p.estLibre(i, j) == false) {
				
				return false;
			}

			return false;
		}
	

	@Override
	public void turn() {
		int[] upTmp=up;
		int[] downTmp=down;
		int[] leftTmp=left;
		int tmpL=leftTmp[0];
		leftTmp[0]=leftTmp[2];
		leftTmp[2]=tmpL;
		int[] rightTmp=right;
		int tmpR=rightTmp[0];
		rightTmp[0]=rightTmp[2];
		rightTmp[2]=tmpR;
		up=leftTmp;
		right=upTmp;
		down=rightTmp;
		left=downTmp;

	}

}
