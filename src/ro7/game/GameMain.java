package ro7.game;

import ro7.engine.Application;

public class GameMain {
	
	public static void main(String[] par) {
		Application app = new Application("Tic", false);
		app.pushScreen(new TitleScreen(app));
		app.startup();
	}

}
