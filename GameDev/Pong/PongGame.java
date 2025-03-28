package GameDev.Pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//Gabriel Cintron
//Date: Mar 19, 2025

public class PongGame extends JPanel implements KeyListener {

	// ---- Instance Variables ----

	public static final int PANEL_WIDTH = 800;
	public static final int PANEL_HEIGHT = 600;
	private static final int READY_TO_SERVE = 0;
	private static final int PLAYING = 0;
	private static final int END_OF_GAME = 0;

	private Ball ball;
	private Paddle rightPaddle;
	private Paddle leftPaddle;
	private double ballSpeed = 0.5;; // Initial ball speed
	private double speedIncrease = 0.0; // Amount to increase speed on paddle hit
	private int gameState;
	private int scoreL;
	private int scoreR;

	// ---- Initializer ----

	public PongGame() {
		System.out.println("Constructing Game Panel.");
		this.addKeyListener(this);
		this.setFocusable(true);
		
		ball = new Ball(400, 300, ballSpeed, ballSpeed, 25, 25, Color.RED);
		rightPaddle = new Paddle(760, 300, 20, 100, 1, KeyEvent.VK_UP, KeyEvent.VK_DOWN, Color.CYAN);
		leftPaddle = new Paddle(20, 300, 20, 100, 1, KeyEvent.VK_W, KeyEvent.VK_S, Color.GREEN);

		gameState = READY_TO_SERVE;

		Timer timer = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rightPaddle.update();
				leftPaddle.update();
				
				if(gameState == PLAYING) {
				ball.update();
				//if ball collides with right paddle, dx = -dx
				if(ball.getBounds().intersects(rightPaddle.getBounds())) {
					// Reposition the ball to be just left of the right paddle
					ball.setX(rightPaddle.getX() - ball.getWidth());
					// Then reverse direction
					ball.setDx(-ball.getDx());
					// Increase ball speed
					ballSpeed += speedIncrease;
					updateBallSpeed();
				}
				//if ball collides with left paddle, dx = -dx
				if(ball.getBounds().intersects(leftPaddle.getBounds())) {
					// Reposition the ball to be just right of the left paddle
					ball.setX(leftPaddle.getX() + leftPaddle.getWidth());	
					// Then reverse direction
					ball.setDx(-ball.getDx());
					// Increase ball speed
					ballSpeed += speedIncrease;
					updateBallSpeed();
				}
				if(ball.isOffPanel()) {
					// if the ball goes off the left side of the screen, reset the game and add a point to the right player
					if(ball.getX() < 0) {
						scoreR++;
						ball.setX(PANEL_WIDTH / 2);
						ball.setY(PANEL_HEIGHT / 2);
						ball.setDx(-ballSpeed);
						ball.setDy(ballSpeed);
					}
					// if the ball goes off the right side of the screen, reset the game and add a point to the left player
					if(ball.getX() > PANEL_WIDTH) {
						scoreL++;
						ball.setX(PANEL_WIDTH / 2);
						ball.setY(PANEL_HEIGHT / 2);
						ball.setDx(ballSpeed);
						ball.setDy(ballSpeed);
					}
					// Reset the ball speed
					ballSpeed = 0.5;
					// Reset the game state
					gameState = READY_TO_SERVE;
					// Reset the ball position
					ball.setX(PANEL_WIDTH / 2);
					ball.setY(PANEL_HEIGHT / 2);
					ball.setDx(0);
					ball.setDy(0);
					// Reset the paddles
					rightPaddle.setY(PANEL_HEIGHT / 2 - rightPaddle.getHeight() / 2);	
					leftPaddle.setY(PANEL_HEIGHT / 2 - leftPaddle.getHeight() / 2);
				}
			}



				repaint();
			}
			
		});
		timer.start();
	}
	
	// Update ball's speed while maintaining its direction
	private void updateBallSpeed() {
		// Keep the direction (positive or negative) but update the magnitude
		if(ball.getDx() > 0) ball.setDx(ballSpeed);
		else ball.setDx(-ballSpeed);
		
		if(ball.getDy() > 0) ball.setDy(ballSpeed);
		else ball.setDy(-ballSpeed);
		
		// System.out.println("Ball speed increased to: " + ballSpeed);
	}

	// ---- Paint Component ----

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));

		// Clear the panel with a background color
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

		// draw the scores
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("Benguiat", Font.PLAIN, 42));
		g2.drawString((String) scoreL, 50, 50);
		g2.drawString((String) scoreR, 650, 50);
		g2.drawString("Press SPACE to start", 300, 50);

		ball.draw(g2);
		rightPaddle.draw(g2);
		leftPaddle.draw(g2);
	}

	public Dimension getPreferredSize() {
		return new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Pong Game");
		frame.add(new PongGame());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		rightPaddle.checkKeyPress(key);
		leftPaddle.checkKeyPress(key);

		if(key == KeyEvent.VK_SPACE) {
			if(gameState == READY_TO_SERVE) {
				gameState = PLAYING;
				ball.setDx(ballSpeed);
				ball.setDy(ballSpeed);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		rightPaddle.checkKeyReleased(key);
		leftPaddle.checkKeyReleased(key);
	}
}