import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//Alex Radu
//Date: Nov 18, 2024

public class FlappyBird extends JPanel implements MouseListener, MouseMotionListener, KeyListener
{
	final int PANEL_WIDTH = 800;
	final int PANEL_HEIGHT = 600;
	
	// Game constants
	final int GRAVITY = 1;
	final int JUMP_FORCE = -12;
	final int BIRD_WIDTH = 50;
	final int BIRD_HEIGHT = 40;
	final int GROUND_HEIGHT = 100;
	final int PIPE_WIDTH = 80;
	final int PIPE_GAP = 200;
	final int PIPE_SPEED = 4;
	final int PIPE_SPAWN_INTERVAL = 120; // frames
	
	// Game variables
	int score;
	int highScore = 0;
	double birdY, birdVelocity;
	int birdX;
	boolean gameStarted = false;
	boolean gameOver = false;
	int frameCount = 0;
	Random random = new Random();
	
	// Pipes
	List<Rectangle> topPipes = new ArrayList<>();
	List<Rectangle> bottomPipes = new ArrayList<>();
	
	// Images
	Image backgroundImg;
	Image birdImg;
	Image topPipeImg;
	Image bottomPipeImg;
	
	public FlappyBird()
	{
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		// Load images
		try {
			backgroundImg = new ImageIcon(this.getClass().getResource("/images/background.png")).getImage();
			birdImg = new ImageIcon(this.getClass().getResource("/images/flappybird.png")).getImage();
			topPipeImg = new ImageIcon(this.getClass().getResource("/images/upper-pipe.png")).getImage();
			bottomPipeImg = new ImageIcon(this.getClass().getResource("/images/lower-pipe.png")).getImage();
		} catch (Exception e) {
			System.out.println("Error loading images: " + e.getMessage());
			// Use default colors if images can't be loaded
		}
		
		resetGame();
		
		Timer timer = new Timer(16, new ActionListener() { // ~60 FPS
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (gameStarted && !gameOver) {
					// Apply gravity
					birdVelocity += GRAVITY;
					birdY += birdVelocity;
					
					// Update pipes
					updatePipes();
					
					// Check collisions
					if (checkCollisions()) {
						gameOver = true;
						if (score > highScore) {
							highScore = score;
						}
					}
					
					frameCount++;
				}
				repaint();
			}
		});
		timer.start();
	}
	
	private void resetGame() {
		score = 0;
		birdX = 150;
		birdY = PANEL_HEIGHT / 2 - BIRD_HEIGHT / 2;
		birdVelocity = 0;
		gameStarted = false;
		gameOver = false;
		frameCount = 0;
		topPipes.clear();
		bottomPipes.clear();
	}
	
	private void updatePipes() {
		// Move pipes
		for (int i = 0; i < topPipes.size(); i++) {
			Rectangle topPipe = topPipes.get(i);
			Rectangle bottomPipe = bottomPipes.get(i);
			
			topPipe.x -= PIPE_SPEED;
			bottomPipe.x -= PIPE_SPEED;
			
			// Check if bird has passed a pipe to increase score
			if (topPipe.x + PIPE_WIDTH == birdX) {
				score++;
			}
		}
		
		// Remove pipes that are off-screen
		for (int i = 0; i < topPipes.size(); i++) {
			if (topPipes.get(i).x + PIPE_WIDTH < 0) {
				topPipes.remove(i);
				bottomPipes.remove(i);
				i--;
			}
		}
		
		// Spawn new pipes
		if (frameCount % PIPE_SPAWN_INTERVAL == 0) {
			spawnPipe();
		}
	}
	
	private void spawnPipe() {
		int pipeHeight = random.nextInt(PANEL_HEIGHT - PIPE_GAP - GROUND_HEIGHT - 100) + 50;
		
		// Top pipe
		Rectangle topPipe = new Rectangle(PANEL_WIDTH, 0, PIPE_WIDTH, pipeHeight);
		topPipes.add(topPipe);
		
		// Bottom pipe
		Rectangle bottomPipe = new Rectangle(PANEL_WIDTH, pipeHeight + PIPE_GAP, PIPE_WIDTH, PANEL_HEIGHT - pipeHeight - PIPE_GAP - GROUND_HEIGHT);
		bottomPipes.add(bottomPipe);
	}
	
	private boolean checkCollisions() {
		// Create bird hitbox
		Rectangle birdHitbox = new Rectangle(birdX, (int)birdY, BIRD_WIDTH, BIRD_HEIGHT);
		
		// Check for ground collision
		if (birdY + BIRD_HEIGHT > PANEL_HEIGHT - GROUND_HEIGHT) {
			return true;
		}
		
		// Check for ceiling collision
		if (birdY < 0) {
			return true;
		}
		
		// Check for pipe collisions
		for (Rectangle topPipe : topPipes) {
			if (birdHitbox.intersects(topPipe)) {
				return true;
			}
		}
		
		for (Rectangle bottomPipe : bottomPipes) {
			if (birdHitbox.intersects(bottomPipe)) {
				return true;
			}
		}
		
		return false;
	}
	
	private void jump() {
		if (gameOver) {
			resetGame();
			return;
		}
		
		if (!gameStarted) {
			gameStarted = true;
		}
		
		// Apply jump force
		birdVelocity = JUMP_FORCE;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		// Draw background
		if (backgroundImg != null) {
			g2.drawImage(backgroundImg, 0, 0, PANEL_WIDTH, PANEL_HEIGHT, this);
		} else {
			g2.setColor(new Color(135, 206, 235)); // Sky blue
			g2.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT - GROUND_HEIGHT);
			g2.setColor(new Color(34, 139, 34)); // Forest green
			g2.fillRect(0, PANEL_HEIGHT - GROUND_HEIGHT, PANEL_WIDTH, GROUND_HEIGHT);
		}
		
		// Draw pipes
		for (int i = 0; i < topPipes.size(); i++) {
			Rectangle topPipe = topPipes.get(i);
			Rectangle bottomPipe = bottomPipes.get(i);
			
			if (topPipeImg != null) {
				g2.drawImage(topPipeImg, topPipe.x, topPipe.y, topPipe.width, topPipe.height, this);
			} else {
				g2.setColor(Color.GREEN);
				g2.fillRect(topPipe.x, topPipe.y, topPipe.width, topPipe.height);
			}
			
			if (bottomPipeImg != null) {
				g2.drawImage(bottomPipeImg, bottomPipe.x, bottomPipe.y, bottomPipe.width, bottomPipe.height, this);
			} else {
				g2.setColor(Color.GREEN);
				g2.fillRect(bottomPipe.x, bottomPipe.y, bottomPipe.width, bottomPipe.height);
			}
		}
		
		// Draw bird
		if (birdImg != null) {
			// Rotate bird based on velocity for more realistic movement
			double rotation = Math.min(Math.max(birdVelocity * 2, -30), 30);
			g2.rotate(Math.toRadians(rotation), birdX + BIRD_WIDTH/2, birdY + BIRD_HEIGHT/2);
			g2.drawImage(birdImg, birdX, (int)birdY, BIRD_WIDTH, BIRD_HEIGHT, this);
			g2.rotate(Math.toRadians(-rotation), birdX + BIRD_WIDTH/2, birdY + BIRD_HEIGHT/2);
		} else {
			g2.setColor(Color.YELLOW);
			g2.fillOval(birdX, (int)birdY, BIRD_WIDTH, BIRD_HEIGHT);
		}
		
		// Draw score
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("Arial", Font.BOLD, 30));
		g2.drawString("Score: " + score, 20, 40);
		g2.drawString("High Score: " + highScore, 20, 80);
		
		// Draw start/game over message
		if (!gameStarted) {
			g2.setColor(new Color(0, 0, 0, 150));
			g2.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
			g2.setColor(Color.WHITE);
			g2.setFont(new Font("Arial", Font.BOLD, 50));
			g2.drawString("Flappy Bird", PANEL_WIDTH/2 - 150, PANEL_HEIGHT/2 - 50);
			g2.setFont(new Font("Arial", Font.BOLD, 30));
			g2.drawString("Click or press SPACE to start", PANEL_WIDTH/2 - 200, PANEL_HEIGHT/2 + 30);
		} else if (gameOver) {
			g2.setColor(new Color(0, 0, 0, 150));
			g2.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
			g2.setColor(Color.WHITE);
			g2.setFont(new Font("Arial", Font.BOLD, 50));
			g2.drawString("Game Over", PANEL_WIDTH/2 - 150, PANEL_HEIGHT/2 - 50);
			g2.setFont(new Font("Arial", Font.BOLD, 30));
			g2.drawString("Score: " + score, PANEL_WIDTH/2 - 70, PANEL_HEIGHT/2 + 30);
			g2.drawString("Click or press SPACE to restart", PANEL_WIDTH/2 - 220, PANEL_HEIGHT/2 + 80);
		}
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Flappy Bird");
		frame.add(new FlappyBird());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		jump();
	}
	
	// Other mouse methods remain unchanged
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			jump();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}
}