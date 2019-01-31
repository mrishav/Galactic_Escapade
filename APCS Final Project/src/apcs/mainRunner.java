package apcs;

public class mainRunner {

	public static void main(String[] args) {
		int backgroundLength = 500;
		int backgroundWidth = 400;
		
		Window.size(backgroundLength, backgroundWidth);
		//MovingWalls movingWalls = new MovingWalls(backgroundLength, backgroundWidth);
		PlayerShip playerShip = new PlayerShip(backgroundLength, backgroundWidth);

		playerShip.makeTitleScreen(backgroundLength, backgroundWidth);
		playerShip.play(backgroundLength, backgroundWidth);
		
		

	}

}