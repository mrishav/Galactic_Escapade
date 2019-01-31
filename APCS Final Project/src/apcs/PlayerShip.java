package apcs;

public class PlayerShip {

	// Player x
	int x;
	// Player y
	int y;
	// I don't rmember what this is used for
	int counter;
	// Checks for if you have lost game
	boolean loseGame;

	// Used to go through the switch statement
	int switchCounter;

	// Box generator x position
	int boxGenX;
	// Box generator y position
	int boxGenY;
	// Box length
	int boxLength;
	// Random int used to determine which box is removed
	int random;

	// Score
	int score;

	// x amount the box shifts
	int boxXShift;
	// y amount th ebox shifts
	int boxYShift;

	// Center square
	MovingWall9Square center;
	// Top right square
	MovingWall9Square tRight;
	// Top left square
	MovingWall9Square tLeft;
	// Top center square
	MovingWall9Square tCenter;
	// Middle right square
	MovingWall9Square mRight;
	// Middle left square
	MovingWall9Square mLeft;
	// Bottom right square
	MovingWall9Square bRight;
	// Bottom left square
	MovingWall9Square bLeft;
	// Bottom center square
	MovingWall9Square bCenter;

	// Constructor
	public PlayerShip(int backgroundLength, int backgroundWidth) {
		// Makes a new Window by the given parameters
		Window.size(backgroundLength, backgroundWidth);
		// Sets x and y to center of screen
		x = backgroundLength / 2;
		y = backgroundWidth / 2;

		// Initializes any variables
		switchCounter = 1;
		loseGame = false;

		boxXShift = 4;
		boxYShift = 2;
		score = 0;

		center = null;
		tRight = null;
		tLeft = null;
		tCenter = null;
		mRight = null;
		mLeft = null;
		bRight = null;
		bLeft = null;
		bCenter = null;

	}

	// Makes the background
	public void makeBackground(int backgroundLength, int backgroundWidth) {

		// Sets background to green
		Window.out.background("green");

		// Perspective lines
		Window.out.color("black");
		Window.out.line(backgroundLength, 0, 0, backgroundWidth);
		Window.out.line(0, 0, backgroundLength, backgroundWidth);

		// Sky
		Window.out.color("light blue");
		Window.out.polygon(0, 0, backgroundLength, 0, backgroundLength / 2, backgroundWidth / 2);

		// Ground
		Window.out.color("brown");
		Window.out.polygon(0, backgroundWidth, backgroundLength, backgroundWidth, backgroundLength / 2,
				backgroundWidth / 2);
		
	}

	// Makes the player object
	public void makePerson() {
		// Makes the player ship at the mouse's x and y
		Window.out.color("red");
		x = Window.mouse.getX();
		y = Window.mouse.getY();
		Window.out.polygon(x + 20, y, x - 20, y, x, y - 15);
	}

	public void play(int backgroundLength, int backgroundWidth) {

		// Checks if you can still fly
		while (loseGame == false) {
			// Sets the random to a random number between 1 and 9
			random = Window.random(1, 9);

			// Checks through 1-9, if it approaches the random number, it doesn't build that
			// block
			switch (switchCounter) {
			case 1:
				// Makes the center block
				if (switchCounter != random) {
					boxGenX = backgroundLength / 2;
					boxGenY = backgroundWidth / 2;
					boxLength = 50;
					center = new MovingWall9Square(false, false, boxLength, boxGenX, boxGenY, backgroundLength,
							backgroundWidth);

				}
				switchCounter++;
			case 2:
				// Makes the top right block
				if (switchCounter != random) {
					boxGenX = backgroundLength / 2 + 50;
					boxGenY = backgroundWidth / 2 - 50;
					boxLength = 50;
					tRight = new MovingWall9Square(true, true, boxLength, boxGenX, boxGenY, backgroundLength,
							backgroundWidth);
				}
				switchCounter++;

			case 3:
				// Makes the top left block
				if (switchCounter != random) {
					boxGenX = backgroundLength / 2 - 50;
					boxGenY = backgroundWidth / 2 - 50;
					boxLength = 50;
					tLeft = new MovingWall9Square(true, true, boxLength, boxGenX, boxGenY, backgroundLength,
							backgroundWidth);
				}
				switchCounter++;
			case 4:
				// Makes the middle right block
				if (switchCounter != random) {
					boxGenX = backgroundLength / 2 + 50;
					boxGenY = backgroundWidth / 2;
					boxLength = 50;
					mRight = new MovingWall9Square(true, false, boxLength, boxGenX, boxGenY, backgroundLength,
							backgroundWidth);
				}
				switchCounter++;
			case 5:
				// Makes the middle left block
				if (switchCounter != random) {
					boxGenX = backgroundLength / 2 - 50;
					boxGenY = backgroundWidth / 2;
					boxLength = 50;
					mLeft = new MovingWall9Square(true, false, boxLength, boxGenX, boxGenY, backgroundLength,
							backgroundWidth);
				}
				switchCounter++;
			case 6:
				// Makes the bottom right block
				if (switchCounter != random) {
					boxGenX = backgroundLength / 2 + 50;
					boxGenY = backgroundWidth / 2 + 50;
					boxLength = 50;
					bRight = new MovingWall9Square(true, true, boxLength, boxGenX, boxGenY, backgroundLength,
							backgroundWidth);
				}
				switchCounter++;
			case 7:
				// Makes the bottom left block
				if (switchCounter != random) {
					boxGenX = backgroundLength / 2 - 50;
					boxGenY = backgroundWidth / 2 + 50;
					boxLength = 50;
					bLeft = new MovingWall9Square(true, true, boxLength, boxGenX, boxGenY, backgroundLength,
							backgroundWidth);
				}
				switchCounter++;
			case 8:
				// Makes the bottom center block
				if (switchCounter != random) {
					boxGenX = backgroundLength / 2;
					boxGenY = backgroundWidth / 2 + 50;
					boxLength = 50;
					bCenter = new MovingWall9Square(false, true, boxLength, boxGenX, boxGenY, backgroundLength,
							backgroundWidth);
				}
				switchCounter++;

			case 9:
				// Makes the top center block
				if (switchCounter != random) {
					boxGenX = backgroundLength / 2;
					boxGenY = backgroundWidth / 2 - 50;
					boxLength = 50;
					tCenter = new MovingWall9Square(false, true, boxLength, boxGenX, boxGenY, backgroundLength,
							backgroundWidth);
				}
				switchCounter++;

				break;
			}

			makeBackground(backgroundLength, backgroundWidth);

			x = Window.mouse.getX();
			y = Window.mouse.getY();

			// Makes the walls start to move

			MovingWall9Square nullSquare = null;

			if (center != null) {
				center.move(boxXShift, boxYShift);
				if (center.getLength() > backgroundLength / 3) {
					x = Window.mouse.getX();
					y = Window.mouse.getY();
					score += center.getScoreIncrease();
					

					System.out.println(score);

					if (center.getHasLost() == true) {
						loseGame = true;
					}
					center = nullSquare;
					switchCounter = 1;
				}
			}

			if (tRight != null) {

				tRight.move(boxXShift, boxYShift);

				if (tRight.getLength() > backgroundLength / 3) {
					x = Window.mouse.getX();
					y = Window.mouse.getY();
					score += tRight.getScoreIncrease();

					if (tRight.getHasLost() == true) {
						System.out.println("CheckPoint");
						loseGame = true;
					}
					tRight = nullSquare;
					switchCounter = 1;

				}
			}
			if (tLeft != null) {
				tLeft.move(boxXShift, boxYShift);

				if (tLeft.getLength() > backgroundLength / 3) {
					x = Window.mouse.getX();
					y = Window.mouse.getY();

					if (tLeft.getHasLost() == true) {
						loseGame = true;
					}
					tLeft = nullSquare;
					switchCounter = 1;

				}
			}
			if (tCenter != null) {
				tCenter.move(boxXShift, boxYShift);
				if (tCenter.getLength() > backgroundLength / 3) {

					if (tCenter.getHasLost() == true) {
						loseGame = true;
					}

					tCenter = nullSquare;
					switchCounter = 1;

				}
			}
			if (mRight != null) {
				mRight.move(boxXShift, boxYShift);
				if (mRight.getLength() > backgroundLength / 3) {

					if (mRight.getHasLost() == true) {
						loseGame = true;
					}
					mRight = nullSquare;
					switchCounter = 1;

				}
			}
			if (mLeft != null) {
				mLeft.move(boxXShift, boxYShift);
				if (mLeft.getLength() > backgroundLength / 3) {

					if (mLeft.getHasLost() == true) {
						loseGame = true;
					}
					mLeft = nullSquare;
					switchCounter = 1;

				}
			}
			if (bRight != null) {
				bRight.move(boxXShift, boxYShift);
				if (bRight.getLength() > backgroundLength / 3) {

					if (bRight.getHasLost() == true) {
						loseGame = true;
					}
					bRight = nullSquare;
					switchCounter = 1;

				}
			}
			if (bLeft != null) {
				bLeft.move(boxXShift, boxYShift);
				if (bLeft.getLength() > backgroundLength / 3) {
					if (bLeft.getHasLost() == true) {
						loseGame = true;
					}
					bLeft = nullSquare;
					switchCounter = 1;

				}
			}
			if (bCenter != null) {
				bCenter.move(boxXShift, boxYShift);
				if (bCenter.getLength() > backgroundLength / 3) {
					if (bCenter.getHasLost() == true) {
						loseGame = true;
					}
					bCenter = nullSquare;
					switchCounter = 1;

				}
			}
			
			Window.out.font("Times New Roman", 30);
			Window.out.color("black");
			Window.out.print("Score:" + score, backgroundLength / 5 - 50, backgroundWidth / 2 - 160);

			makePerson();

			Window.frame(1);
		}
	}

	public void makeTitleScreen(int backgroundLength, int backgroundWidth) {
		int SbuttonX = backgroundLength / 2;
		int SbuttonY = backgroundWidth / 2;
		int HbuttonX = backgroundLength / 2;
		int HbuttonY = backgroundWidth / 2 + 75;
		boolean SbuttonPressed = false;

		while (SbuttonPressed == false) {
			Window.frame();
			Window.out.background("grey");

			Window.out.font("Times New Roman", 30);
			Window.out.color("green");
			Window.out.print("Ship", backgroundLength / 2 - 30, backgroundWidth / 2 - 80);

			//Start Button
			Window.out.color("White");
			Window.out.rectangle(SbuttonX, SbuttonY, 100, 60);
			Window.out.color("black");
			Window.out.print("Start", SbuttonX - 30, SbuttonY + 10);
			
			//Help Button
			Window.out.color("White");
			Window.out.rectangle(HbuttonX, HbuttonY, 100, 60);
			Window.out.color("black");
			Window.out.print("Help", HbuttonX-30, HbuttonY+10);

			if (Math.abs(Window.mouse.getX() - SbuttonX) <= 50 && Math.abs(Window.mouse.getY() - SbuttonY) <= 35
					&& Window.mouse.clicked()) {
				SbuttonPressed = true;
			}
			if (Math.abs(Window.mouse.getX() - HbuttonX) <= 50 && Math.abs(Window.mouse.getY() - HbuttonY) <= 35
					&& Window.mouse.clicked()) {
				
				//System.out.println("Use the mouse to avoid the oncoming wall");
				//System.out.println("Go through the holes");
				//Window.wait(1);
				Window.out.clear();
				
				Window.out.color("white");
				Window.out.print("Mouse to move", 150, 200);
				Window.out.print("Avoid the walls", 150, 250);
				
				
				
						
			}

		}
	}
	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getBoxGenX() {
		return boxGenX;
	}

	public void setLoss(boolean lose) {
		loseGame = lose;
	}

	/*
	 * public void move() { while (1 < 2) { Window.out.color("red"); x =
	 * Window.mouse.getX(); y = Window.mouse.getY(); Window.out.circle(x, y, 25);
	 * Window.frame(1); }
	 * 
	 * }
	 */

}