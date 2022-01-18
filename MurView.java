package travail;

import java.awt.Color;
import java.awt.Graphics;

import pobj.ihm.Drawable;

public class MurView implements Drawable{
	private Mur mur;
	
	public MurView(Mur m) {
		mur=m;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect((int)mur.getPosX(), (int)mur.getPosY(), (int)mur.getLarg(), (int)mur.getHaut());
	}
	
	public int getPriority() {
		return 0;
	}
}
