package apcs;

public class MovingWall9Square {

	int x;
	int y;
	int WindowMaxLength;
	int WindowMaxWidth;
	boolean hMovement;
	boolean vMovement;

	boolean hasLost;

	int length;
	int scoreIncrease;

	public MovingWall9Square(boolean hMovementX, boolean vMovementY, int lengthO, int xP, int yP, int maxWindowLength,
			int maxWindowWidth) {
		WindowMaxLength = maxWindowLength;
		WindowMaxWidth = maxWindowWidth;
		x = xP;
		y = yP;
		length = lengthO;
		hMovement = hMovementX;
		vMovement = vMovementY;

		hasLost = false;
		scoreIncrease = 0;
	}

	public void move(int xShift, int yShift) {
		Window.out.color("grey");

		Window.wait(0.01);
		length += 4;
		// Window.out.square(x, y, length);

		// Checks if the square has to go horizontally

		if(length>WindowMaxLength/6) {
			length+=2;
		}
		if (hMovement == true) {
			if (x < WindowMaxLength / 2) {
				x -= xShift;
			}
			if (x > WindowMaxLength / 2) {
				x += xShift;
			}
		}
		if (vMovement == true) {
			if (y < WindowMaxWidth / 2) {
				y -= yShift+1;
			}
			if (y > WindowMaxWidth / 2) {
				y += yShift+1;
			}
		}

		Window.out.square(x, y, length);
		int mX = Window.mouse.getX();
		int mY = Window.mouse.getY();
		if (length > WindowMaxLength / 3) {
			// System.out.println("Check");
			if (mX > x - length / 2 && mX < x + length / 2) {
				if (mY > y - length / 2 && mY < y + length / 2) {
					hasLost = true;
					return;
					// System.out.println(hasLost);
				}

			}else {
				scoreIncrease++;
			}
		}
	}

	public int getLength() {
		return length;
	}

	public boolean getHasLost() {
		return hasLost;
	}
	public int getScoreIncrease() {
		return scoreIncrease;
	}

}