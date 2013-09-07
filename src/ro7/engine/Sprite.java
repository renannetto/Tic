package ro7.engine;

import java.awt.Graphics2D;

import cs195n.Vec2f;

public abstract class Sprite {
	
	protected Vec2f position;
	
	protected Sprite(Vec2f position) {
		this.position = position;
	}
	
	public void draw(Graphics2D g) {
		g.translate(position.x, position.y);
		drawSprite(g);
		g.translate(-position.x, -position.y);
	}
	
	public abstract void drawSprite(Graphics2D g);

}
