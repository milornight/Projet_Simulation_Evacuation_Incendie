package travail;

import java.util.Collections;

import pobj.simuagent.Strategy;
import pobj.tools.Vecteur2D;

public class StrategyFonceur implements Strategy {
	private Salle salle;
	
	public StrategyFonceur(Salle s) {
		salle=s;
	}
	
	public Vecteur2D deplacement(Personne p) {
		Vecteur2D cibleOpt=Collections.min(salle.getListeCibles(), new ComparateurPosition (salle,p.getPos()));
		return cibleOpt;
	}

}
