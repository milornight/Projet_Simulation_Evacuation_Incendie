package travail;

import java.awt.Color;
import java.awt.Graphics;

import pobj.ihm.Drawable;

public class PersonneView implements Drawable {
	private Personne p;
	
	public PersonneView(Personne p) {
		this.p=p;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval((int) p.getPosX(), (int) p.getPosY(), (int)(2*p.getRayon()),(int) (2*p.getRayon()));
	}
	
	public int getPriority() {
		return 0;
	}
	
	public void move(){
		p.move();
	}
}
