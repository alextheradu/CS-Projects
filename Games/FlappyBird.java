import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
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

	int score;
	int x1, y1, w1, h1;
	int x3, y3, w3, h3;
    int birdx, birdy, birdw, birdh;
    int hitboxX, hitboxY, hotboxW, hitboxH;
	double xc, yc, wc, hc;
    boolean up, down, left, right;
    boolean isFacingRight;
	boolean selectedRect;
	boolean selectedRect2;
	boolean selectedCircle;
    List<Integer> pressedKeys = new ArrayList<>();

	public FlappyBird ()
		{
			this.addMouseListener(this);
			this.addMouseMotionListener(this);
            this.addKeyListener(this);
            this.setFocusable(true);
            this.requestFocusInWindow();
			w3 = h3 = 200;
			score = 0;
            birdx = 50;
            birdy = 50;
            birdw = 50;
            birdh = 50;

            isFacingRight = true;

			Timer timer = new Timer(1, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					score++;
					x3+=2;
                    y3+=2;
					if(x3 > PANEL_WIDTH)
						x3 = -w3;
                    if(y3 > PANEL_HEIGHT)
                        y3 = -h3;

					xc+=1;
					

                    if(left) birdx--;
                    if(right) birdx++;
                    if(up) birdy--;
                    if(down) birdy++;
					if(birdx > PANEL_WIDTH)
						birdx = -birdw;
                    if(birdy > PANEL_HEIGHT)
                        birdy = -birdh;
					if(birdx < -birdw)
						birdx = PANEL_WIDTH;
					if(birdy < -birdh)
						birdy = PANEL_HEIGHT;

					if(xc > PANEL_WIDTH)
						xc = -200;

					hitboxX = birdx + 10;
					hitboxY = birdy + 10;
					hotboxW = birdw - 20;
					hitboxH = birdh - 20;
					repaint();
				}
			});
			timer.start();
			
		}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g); // Ensure proper rendering
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(135, 196, 210));
		g2.drawRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
		g2.setColor(Color.black);
		g2.drawString("Score: " + score, 600, 50);

        Image birdPic = new ImageIcon(this.getClass().getResource("bird.png")).getImage();
        if(isFacingRight)
			g2.drawImage(birdPic, birdx, birdy, birdw, birdh, this);
		else
			g2.drawImage(birdPic, birdx + 50, birdy, -birdw, birdh, this);
		
		g2.setColor(Color.RED); // Use a distinct color for visibility
		g2.drawRect(hitboxX, hitboxY, hotboxW, hitboxH);
		
		g2.setColor(Color.WHITE);
		g2.fillOval(50 + (int) xc, 50, 50, 50);
		g2.fillOval(80 + (int) xc, 35, 50, 50);
		g2.fillOval(85 + (int) xc, 60, 40, 40);
		g2.fillOval(105 + (int) xc, 50, 50, 50);
		g2.fillOval(138 + (int) xc, 65, 30, 30);
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(800,600);
		
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("My first bad game");
		frame.add(new FlappyBird());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e)
	{
	}
	public static boolean isInRectangle(int x, int y, int w, int h, int xm, int ym)
	{
		return xm > x && xm < x + w && ym > y && ym < y + h;
	}
	public static boolean isInCircle(int x, int y, int w, int h, int xm, int ym)
	{
		//Calculate radius
		int r = w / 2;
		//Calculate coordinates of center
		int xc = x + r;
		int yc = y + r;
		double dist = (Math.sqrt(Math.pow(yc-ym, 2) + Math.pow(xc-xm,2)));
		return dist < r;
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		//Get mouse coordinates
		int xm = e.getX();
		int ym = e.getY();
	}
	@Override
	public void mouseReleased(MouseEvent e)
	{
	}
	@Override
	public void mouseEntered(MouseEvent e)
	{
	}
	@Override
	public void mouseExited(MouseEvent e)
	{
	}
	@Override
	public void mouseDragged(MouseEvent e)
	{
		int xm = e.getX();
		int ym = e.getY();

	}
	@Override
	public void mouseMoved(MouseEvent e)
	{
		int xm = e.getX();
		int ym = e.getY();
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
	}
	@Override
	public void keyPressed(KeyEvent e) {
        int keyPressed = e.getKeyCode();
        if (!pressedKeys.contains(keyPressed)) {
            pressedKeys.add(keyPressed);
        }
        System.out.println("Key Pressed");
        System.out.println(keyPressed);
        if(keyPressed == 39)
		{
			right = true; left = false; up = false; down = false;
		}
        else if(keyPressed == 37)
		{ 
			left = true; right = false; up = false; down = false;
		}
        else if(keyPressed == 38){
			up = true; right = false; left = false; down = false;
		}
        else if(keyPressed == 40)
		{ 
			down = true; right = false; left = false; up = false;
		}
        if(keyPressed == 39) isFacingRight = true;
        else if(keyPressed == 37) isFacingRight = false;
	}
	@Override
	public void keyReleased(KeyEvent e) {
        int keyReleased = e.getKeyCode();
        pressedKeys.remove(Integer.valueOf(keyReleased));
        {
			left = right = up = down = false;
        
        // Handle horizontal direction
        for (int i = pressedKeys.size() - 1; i >= 0; i--) {
            int key = pressedKeys.get(i);
            if (key == KeyEvent.VK_LEFT) {
                left = true;
                isFacingRight = false;
            } else if (key == KeyEvent.VK_RIGHT) {
                right = true;
                isFacingRight = true;
            }
        }
        
        // Handle vertical direction
        for (int i = pressedKeys.size() - 1; i >= 0; i--) {
            int key = pressedKeys.get(i);
            if (key == KeyEvent.VK_UP) {
                up = true;
            } else if (key == KeyEvent.VK_DOWN) {
                down = true;
            }
		}
        if(keyReleased == 39) right = false;
        else if(keyReleased == 37) left = false;
        else if(keyReleased == 38) up = false;
        else if(keyReleased == 40) down = false;

	}
	}
}