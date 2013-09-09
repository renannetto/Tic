package ro7.engine.sprites;

import java.awt.Graphics2D;

import cs195n.Vec2f;

public abstract class Sprite {
	
	protected Vec2f position;
	
	protected Sprite(Vec2f position) {
		this.position = position;
	}
	
	/**
	 * Translate to the sprite position and draw it
	 * @param g Graphics2D object to draw on the screen
	 */
	public void draw(Graphics2D g) {
		g.translate(position.x, position.y);
		drawSprite(g);
		g.translate(-position.x, -position.y);
	}
	
	/**
	 * Draw the sprite
	 * @param g Graphics2D object to draw on the screen
	 */
	public abstract void drawSprite(Graphics2D g);

}
