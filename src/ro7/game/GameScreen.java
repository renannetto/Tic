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
import ro7.game.sprites.Board;
import ro7.game.sprites.TicUI;
import cs195n.Vec2f;

public class GameScreen extends Screen {
	
	private TicUI ui;
	private ro7.game.models.Board boardModel;
	private int currentPlayer;

	protected GameScreen(Application app) {
		super(app);
		boardModel = new ro7.game.models.Board();
		currentPlayer = 1;
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
		
		Board board = new Board(new Vec2f(0.0f, 0.0f), Math.min(windowSize.x, windowSize.y), boardModel.toString());
		board.draw(g);
	}

	@Override
	public void onKeyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onKeyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case 27: app.popScreen();
		break;
		case 49: setSquare(1);
		break;
		case 50: setSquare(2);
		break;
		case 51: setSquare(3);
		break;
		case 52: setSquare(4);
		break;
		case 53: setSquare(5);
		break;
		case 54: setSquare(6);
		break;
		case 55: setSquare(7);
		break;
		case 56: setSquare(8);
		break;
		case 57: setSquare(9);
		break;
		}
	}

	private void setSquare(int position) {
		if (currentPlayer == 1) {
			boardModel.setX(position);
			currentPlayer = 2;
		} else {
			boardModel.setCircle(position);
			currentPlayer = 1;
		}
	}

	@Override
	public void onKeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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

}
