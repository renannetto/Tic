package ro7.engine.sprites;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import cs195n.Vec2f;

public class Circle extends Sprite {
	
	private float size;
	private Color color;

	public Circle(Vec2f position, float size, Color color) {
		super(position);
		this.size = size;
		this.color = color;
	}

	@Override
	public void drawSprite(Graphics2D g) {
		g.setColor(color);
		
		Ellipse2D circle = new Ellipse2D.Float(0.0f, 0.0f, size, size);
		g.draw(circle);
	}

}
