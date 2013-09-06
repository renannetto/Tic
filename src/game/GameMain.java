package game;

import engine.Application;

public class GameMain {
	
	public static void main(String[] par) {
		Application app = new Application("Tic", false);
		app.startup();
	}

}
