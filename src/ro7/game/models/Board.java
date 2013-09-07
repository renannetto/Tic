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
			board.set(position - 1, 'X');
			return true;
		}
		return false;
	}

	public boolean setCircle(int position) {
		if (isEmpty(position)) {
			board.set(position - 1, 'O');
			return true;
		}
		return false;
	}
	
	public boolean isEmpty(int position) {
		char square = board.get(position - 1);
		return square=='_';
	}
	
	public boolean isComplete() {
		return false;
	}
	
	public boolean isDraw() {
		return !board.contains('_') && !isComplete();
	}

	@Override
	public String toString() {
		String boardString = "";
		for (Character square : board) {
			boardString += square;
		}
		return boardString;
	}

	public String winner() {
		if (!isComplete()) {
			return "There is no winner";
		}
		return "Player X is the winner";
	}

}
