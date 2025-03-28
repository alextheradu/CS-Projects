package GameDev.Pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Paddle {
	private double x, y, dx, dy;
	private int width, height;
	private int upKey, downKey, leftKey, rightKey;
	private boolean up, down, left, right;
	private Color color;

	public Paddle(double x, double y, int width, int height, double dy, int upKey, int downKey, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.dy = dy;
		this.upKey = upKey;
		this.downKey = downKey;
		this.color = color;
	}
	
	public void update() {
	    if(up) {
	        y -= dy;
	        // Prevent paddle from going above the screen
	        if(y < 0) {
	            y = 0;
	        }
	    }
	    if(down) {
	        y += dy;
	        // Prevent paddle from going below the screen
	        if(y + height > PongGame.PANEL_HEIGHT) {
	            y = PongGame.PANEL_HEIGHT - height;
	        }
	    }
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, width, height);
	}
	
	public void checkKeyPress(int key) {
		if(key == upKey) up = true;
		if(key == downKey) down = true;
	}

	public void checkKeyReleased(int key) {
		if(key == upKey) up = false;
		if(key == downKey) down = false;
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(color);
		g2.fillRect((int)x, (int)y, width, height);
		g2.setColor(Color.BLACK);
		g2.drawRect((int)x, (int)y, width, height);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getDx() {
		return dx;
	}

	public double getDy() {
		return dy;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getUpKey() {
		return upKey;
	}

	public int getDownKey() {
		return downKey;
	}

	public int getLeftKey() {
		return leftKey;
	}

	public int getRightKey() {
		return rightKey;
	}

	public boolean isUp() {
		return up;
	}

	public boolean isDown() {
		return down;
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	public Color getColor() {
		return color;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setUpKey(int upKey) {
		this.upKey = upKey;
	}

	public void setDownKey(int downKey) {
		this.downKey = downKey;
	}

	public void setLeftKey(int leftKey) {
		this.leftKey = leftKey;
	}

	public void setRightKey(int rightKey) {
		this.rightKey = rightKey;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Paddle [x=" + x + ", y=" + y + ", dx=" + dx + ", dy=" + dy + ", width=" + width + ", height=" + height
				+ ", upKey=" + upKey + ", downKey=" + downKey + ", leftKey=" + leftKey + ", rightKey=" + rightKey
				+ ", up=" + up + ", down=" + down + ", left=" + left + ", right=" + right + ", color=" + color + "]";
	}

}
