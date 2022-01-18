package travail;

import java.util.Comparator;

import pobj.tools.Vecteur2D;

public class ComparateurPosition implements Comparator<Vecteur2D>{
	private Vecteur2D pos;
	private Salle salle;
	
	public ComparateurPosition(Salle s, Vecteur2D v) {
		pos=v;
		salle=s;
	}
	
	public int compare(Vecteur2D c1, Vecteur2D c2) {
		double scoreC1 = pos.distance(c1)+Terrain.level(salle.get(c1))*1000;
		double scoreC2 = pos.distance(c2)+Terrain.level(salle.get(c2))*1000;
		if (scoreC1 > scoreC2)
			return 1;
		if (scoreC1 < scoreC2)
			return -1;
		return 0;
	}
}
