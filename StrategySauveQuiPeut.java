package travail;

import java.util.Collections;

import pobj.simuagent.Strategy;
import pobj.tools.Vecteur2D;


/*
Classe pour construire une stratégie complexe dirigeant la personne vers la sortie la plus proche
*/
public class StrategySauveQuiPeut implements Strategy{
	private Salle salle;
	
	public StrategySauveQuiPeut(Salle s) {
		salle=s;
	}
	
	public Vecteur2D deplacement(Personne p) {
		Vecteur2D cibleOpt = null;
		cibleOpt = Collections.min(salle.getListeCibles(), new ComparateurPosition (salle,p.getPos()));
		p.setDir(cibleOpt);
		return cibleOpt;
	}
}
