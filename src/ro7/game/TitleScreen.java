package ro7.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Rectangle2D;

import ro7.engine.Application;
import ro7.engine.Screen;
import ro7.engine.sprites.Message;
import cs195n.Vec2f;
import cs195n.Vec2i;

public class TitleScreen extends Screen {

	private Message title;
	private Message startMessage;

	protected TitleScreen(Application app) {
		super(app);
	}

	@Override
	public void onTick(long nanosSincePreviousTick) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDraw(Graphics2D g) {
		Rectangle2D background = new Rectangle(0, 0, windowSize.x, windowSize.y);
		g.setColor(Color.BLACK);
		g.draw(background);
		g.fill(background);

		title.draw(g);

		startMessage.draw(g);
	}

	@Override
	public void onKeyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onKeyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == 10) {
			app.pushScreen(new GameScreen(app));
		}
	}

	@Override
	public void onKeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMouseClicked(MouseEvent e) {
		app.pushScreen(new GameScreen(app));
	}

	@Override
	public void onMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub

	}

	public void onResize(Vec2i newSize) {
		super.onResize(newSize);

		try {
			float titleX = windowSize.x / 3.0f;
			float titleY = windowSize.y / 3.0f;
			int fontSize = windowSize.x / 24;
			title = new Message("Welcome to Tic!", fontSize, Color.WHITE, new Vec2f(
					titleX, titleY));

			float startMessageX = titleX - 50;
			float startMessageY = 2*titleY;
			startMessage = new Message(
					"Click on the screen or press Enter to start", fontSize/2,
					Color.WHITE, new Vec2f(startMessageX, startMessageY));
		} catch (NullPointerException e) {
			System.out.println("No windowSize defined");
		}
	}

}
