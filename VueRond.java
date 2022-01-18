package travail;

import java.awt.Color;

import java.awt.Graphics;

import pobj.ihm.Drawable;

public class VueRond implements Drawable{
	private double x,y;
	private double rayon;
	
	public VueRond(double x, double y, double rayon) {
		this.x=x;
		this.y=y;
		this.rayon=rayon;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawOval((int) x, (int) y, (int)(2*rayon),(int) (2*rayon));
	}
	
	public int getPriority() {
		return 0;
	}
	
	public void move() {
		x=x+1;
		y=y+1;
	}

}



