package ro7.engine.sprites;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import cs195n.Vec2f;

public class Message extends Sprite {
	
	private String text;
	private int fontSize;
	private Color fontColor;
	
	public Message(String text, int fontSize, Color fontColor, Vec2f position) {
		super(position);
		this.text = text;
		this.fontSize = fontSize;
		this.fontColor = fontColor;
	}

	@Override
	public void drawSprite(Graphics2D g) {
		g.setFont(new Font("Arial", Font.PLAIN, fontSize));
		g.setColor(fontColor);
		
		FontMetrics font = g.getFontMetrics();
		Rectangle2D bounds = font.getStringBounds(text, g);
		g.drawString(text, (float)bounds.getMinX(), (float)bounds.getMaxY());
	}

}
