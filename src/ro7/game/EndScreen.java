package ro7.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import ro7.engine.Application;
import ro7.engine.Screen;
import ro7.game.sprites.Message;
import cs195n.Vec2f;

public abstract class EndScreen extends Screen {
	
	private String text;

	protected EndScreen(Application app, String text) {
		super(app);
		this.text = text;
	}
	
	@Override
	public void onDraw(Graphics2D g) {
		Rectangle2D background = new Rectangle(0, 0, windowSize.x, windowSize.y);
		g.setColor(Color.BLACK);
		g.draw(background);
		g.fill(background);

		float endX = windowSize.x / 3.0f;
		float endY = windowSize.y / 4.0f;
		Message endMessage = new Message(text, 48, Color.WHITE, new Vec2f(
				endX, endY));
		endMessage.draw(g);

		float restartMessageX = windowSize.x / 3.0f - 100;
		float restartMessageY = windowSize.y / 4.0f + 50;
		Message restartMessage = new Message("Click on the screen or press r to restart", 28,
				Color.WHITE, new Vec2f(restartMessageX, restartMessageY));
		restartMessage.draw(g);
	}
	
	@Override
	public void onKeyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == 82) {
			app.popScreen();
			app.pushScreen(new GameScreen(app));
		}
	}
	
	@Override
	public void onMouseClicked(MouseEvent e) {
		app.popScreen();
		app.pushScreen(new GameScreen(app));
	}

}
