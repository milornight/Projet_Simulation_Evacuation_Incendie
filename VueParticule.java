package travail;

import java.awt.Color;
import java.awt.Graphics;

import pobj.ihm.Drawable;
import pobj.physics.CerclePhysique;


public class VueParticule implements Drawable{
	private CerclePhysique r;
	
	public VueParticule(CerclePhysique r){
		this.r=r;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.drawOval((int) r.getPosX(), (int) r.getPosY(), (int)(2*r.getRayon()),(int) (2*r.getRayon()));
	}
	
	public int getPriority(){
		return 0;
	}
}

