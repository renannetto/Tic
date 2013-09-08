package ro7.game.sprites;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

import ro7.engine.sprites.Circle;
import ro7.engine.sprites.Sprite;
import cs195n.Vec2f;

public class Board extends Sprite {

	private int size;
	private String board;

	public Board(Vec2f vec2f, int size, String board) {
		super(vec2f);
		this.size = size;
		this.board = board;
	}

	@Override
	public void drawSprite(Graphics2D g) {
		g.setColor(Color.WHITE);

		float space = size / 3.0f;

		drawBoardLine(g, 0.0f, space, size, space);
		drawBoardLine(g, 0.0f, 2 * space, size, 2 * space);
		drawBoardLine(g, space, 0.0f, space, size);
		drawBoardLine(g, 2 * space, 0.0f, 2 * space, size);

		for (int i = 0; i < 9; i++) {
			char square = board.charAt(i);
			drawSquare(g, square, i+1);
		}
	}
	
	public void drawSquare(Graphics2D g, char square, int pos) {
		int xPosition = (pos - 1) % 3;
		int yPosition = (pos - 1) / 3;
		float space = size / 3.0f;
		
		switch (square) {
		case 'X':
			TicX x = new TicX(new Vec2f(space * xPosition, space
				* yPosition), space);
			x.draw(g);
			break;
		case 'O':
			Circle circle = new Circle(new Vec2f(space * xPosition, space
					* yPosition), space, Color.WHITE);
			circle.draw(g);
			break;
		}
	}

	private void drawBoardLine(Graphics2D g, float x1, float x2, float x3,
			float x4) {
		Line2D boardLine;
		boardLine = new Line2D.Float(x1, x2, x3, x4);
		g.draw(boardLine);
	}
	
	public void setState(String board) {
		this.board = board;
	}

	public int getClickedSquare(Point point) {
		int x = point.x;
		int y = point.y;
		float space = size / 3.0f;
		
		int column = (int)(x/space);
		int row = (int)(y/space);
		
		return (column+1) + (row*3);
	}

}
