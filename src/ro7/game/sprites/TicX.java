package ro7.game.sprites;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import ro7.engine.sprites.Sprite;
import cs195n.Vec2f;

public class TicX extends Sprite {
	
	private float size;

	public TicX(Vec2f position, float size) {
		super(position);
		this.size = size;
	}

	@Override
	public void drawSprite(Graphics2D g) {
		g.setColor(Color.WHITE);
		
		Line2D firstLine = new Line2D.Float(0.0f, 0.0f, size, size);
		Line2D secondLine = new Line2D.Float(size, 0.0f, 0.0f, size);
		g.draw(firstLine);
		g.draw(secondLine);
	}

}
