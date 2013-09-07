package ro7.game.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

	List<Character> board;

	public Board() {
		board = new ArrayList<Character>(9);
		for (int i = 0; i < 9; i++) {
			board.add('_');
		}
	}

	public boolean setX(int position) {
		if (isEmpty(position)) {
			board.add(position - 1, 'X');
			return true;
		}
		return false;
	}

	public boolean setCircle(int position) {
		if (isEmpty(position)) {
			board.add(position - 1, 'O');
			return true;
		}
		return false;
	}
	
	public boolean isEmpty(int position) {
		char square = board.get(position - 1);
		return square=='_';
	}

	@Override
	public String toString() {
		String boardString = "";
		for (Character square : board) {
			boardString += square;
		}
		return boardString;
	}

}
