package ro7.game.sprites;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import ro7.engine.sprites.Message;
import ro7.engine.sprites.Sprite;
import cs195n.Vec2f;
import cs195n.Vec2i;

public class TicUI extends Sprite {
	
	private Vec2i dimensions;
	private int player;
	private int time;

	public TicUI(Vec2f position, Vec2i dimensions, int player, int time) {
		super(position);
		this.dimensions = dimensions;
		this.player = player;
		this.time = time;
	}

	@Override
	public void drawSprite(Graphics2D g) {
		Rectangle2D uiArea = new Rectangle(dimensions.x, dimensions.y);
		g.setColor(Color.GRAY);
		g.draw(uiArea);
		g.fill(uiArea);
		
		int fontSize = dimensions.x/20;
		float space = dimensions.y/4.0f;
		
		Message timeMessage = new Message("Remaining time: " + time + " ms", fontSize, Color.WHITE, new Vec2f(100.0f, space));
		timeMessage.draw(g);
		
		String playerString = "Current player: ";
		if (player == 1) {
			playerString += "X";
		} else {
			playerString += "O";
		}
		Message playerMessage = new Message(playerString, fontSize, Color.WHITE, new Vec2f(100.0f, 2*space));
		playerMessage.draw(g);
		
		Message restartMessage = new Message("Press r to restart", fontSize, Color.WHITE, new Vec2f(100.0f, 3*space));
		restartMessage.draw(g);
	}

	public void setTime(int remainingTime) {
		this.time = remainingTime;
	}

	public void setPlayer(int currentPlayer) {
		this.player = currentPlayer;
	}

}
