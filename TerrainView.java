package travail;

import java.awt.Color;
import java.awt.Graphics;

import pobj.ihm.Drawable;

public class TerrainView implements Drawable{
	private int x;
	private int y;
	private int larg;
	private int haut;
	private Color c;
	public static final Color C_SCENE=Color.BLUE;
	public static final Color C_SAFE=Color.GREEN;
	public static final Color C_EXIT=Color.MAGENTA;
	
	public TerrainView(int x, int y, int larg, int haut, Color c) {
		this.x=x;
		this.y=y;
		this.larg=larg;
		this.haut=haut;
		this.c=c;
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillRect(x,y,larg,haut);
	}
	
	public int getPriority() {
		return 0;
	}
}
