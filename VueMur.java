package travail;

import java.awt.Color;
import java.awt.Graphics;

import pobj.ihm.Drawable;
import pobj.physics.RectanglePhysique;


public class VueMur implements Drawable {
	private RectanglePhysique r;
	
	public VueMur(RectanglePhysique r){
		this.r=r;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.drawRect((int) r.getPosX(), (int) r.getPosY(), (int)(r.getLarg()),(int) (r.getHaut()));
	}
	
	public int getPriority(){
		return 0;
	}
}
