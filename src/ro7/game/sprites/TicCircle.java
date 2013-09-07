package ro7.game.sprites;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import cs195n.Vec2f;

public class TicCircle extends Sprite {
	
	private float size;

	public TicCircle(Vec2f position, float size) {
		super(position);
		this.size = size;
	}

	@Override
	public void draw(Graphics2D g) {
		g.translate(position.x, position.y);
		g.setColor(Color.WHITE);
		
		Ellipse2D circle = new Ellipse2D.Float(0.0f, 0.0f, size, size);
		g.draw(circle);
		
		g.translate(-position.x, -position.y);
	}

}