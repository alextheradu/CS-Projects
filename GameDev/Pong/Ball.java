package GameDev.Pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private double x, y, dx, dy;
	private int width, height;
	private Color color;

	public Ball(double x, double y, double dx, double dy, int width, int height, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public void update() {
		x+=dx;
		// if(x<0||x+width>PongGame.PANEL_WIDTH) dx =- dx;
		// y+=dy;
		if(y<0||y+width>PongGame.PANEL_HEIGHT) dy =- dy;
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, width, height);
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(color);
		g2.fillOval((int)x, (int)y, width, height);
		g2.setColor(Color.BLACK);
		g2.drawOval((int)x, (int)y, width, height);
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

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Ball [x=" + x + ", y=" + y + ", dx=" + dx + ", dy=" + dy + ", width=" + width + ", height=" + height
				+ ", color=" + color + "]";
	}

	public boolean isOffPanel() {
		return x < 0 || x + width > PongGame.PANEL_WIDTH || y < 0 || y + height > PongGame.PANEL_HEIGHT;
	}

}