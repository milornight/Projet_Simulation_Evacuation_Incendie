package travail;

import pobj.physics.CerclePhysique;
import pobj.simuagent.Strategy;
import pobj.tools.Vecteur2D;

public class Personne extends CerclePhysique{
	private int id;
	private static int cpt=0;
	private Vecteur2D target;
	private Strategy str;
	
	public Personne(double x,double y){
		super(x,y,2.,1.);
		id=cpt;
		cpt++;
		target=Vecteur2D.buildRandomVecteur();
	}
	
	
	public Personne(double x,double y,Strategy str){
		super(x,y,2.,1.);
		id=cpt;
		cpt++;
		this.str=str;
	}
	
	
	public void setDir(Vecteur2D d) {
		super.setDir(d);
	}
	
	public void move(){
		Vecteur2D v=str.deplacement(this);
		target=this.getPos().minus(v.fact(0.1));
		target=new Vecteur2D(target).normalize();
		setDir(target);
		super.setVit(1.);
	}
	
	public Vecteur2D getTarget(){
		return target;
	}
	
}
