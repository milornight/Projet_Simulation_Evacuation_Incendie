package travail;

import java.util.ArrayList;

import pobj.tools.Vecteur2D;

public class Salle {
	private ArrayList<Vecteur2D> listeCibles;
	private Terrain[][] terr;
	public final static int COTE=10;
	
	public Salle(Terrain[][] t){
		terr=t;
		listeCibles=new ArrayList<Vecteur2D>();

		
	}
	
	public void add(Vecteur2D v){
		listeCibles.add(v);
	}
	
	public ArrayList<Vecteur2D> getListeCibles(){
		return listeCibles;
	}
	
	public Terrain get(int i,int j){
		return terr[i][j];
	}
	
	public Terrain get(Vecteur2D v){
		return terr[(int) ((v.getX())/COTE)][(int) ((v.getY())/COTE)];
	}
	
	public int getHaut(){
		return terr[0].length;
	}
	
	public int getLarg(){
		return terr.length;
	}
	
	public boolean isVisible(Vecteur2D source, Vecteur2D target){
        Vecteur2D dir = target.minus(source);
        dir.normalize();
        while(get(source) != Terrain.Mur){
            source = source.add(dir);
            if(source.distance(target) < 2)
                return true;
        }
        return false;
    }

}
