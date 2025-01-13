import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//Alex Radu
//Date: Nov 18, 2024

public class ArrowKeysGame extends JPanel implements MouseListener, MouseMotionListener, KeyListener
{
	final int PANEL_WIDTH = 800;
	final int PANEL_HEIGHT = 600;

	int score;
	int x1, y1, w1, h1;
	int x3, y3, w3, h3;
	int x4, y4, w4, h4, lastX, lastY;
    boolean left, right, up, down;
	boolean selectedRect;
	boolean selectedRect2;
	boolean selectedCircle;
	public ArrowKeysGame ()
		{
			this.addMouseListener(this);
            this.addKeyListener(this);
			this.addMouseMotionListener(this);
            this.setFocusable(true);
			x1 = 30;
			y1 = 50;
			w1 = 310;
			h1 = 100;
			w3 = h3 = 150;
			x4 = 400;
			y4 = 200;
			h4 = w4 = 100;
			score = 0;

			Timer timer = new Timer(5, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					score++;
					x3++;
                    y3++;
					if(x3 > PANEL_WIDTH)
						x3 = -w3;
                    if(y3 > PANEL_WIDTH)
						y3 = -w3;

                    if(left) x1--;
                    if(right) x1++;
                    if(up) y1--;
                    if(down) y1++;
                    repaint();
				}
			});
			timer.start();
			
		}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.drawString("Score: " + score, 600, 50);
		g2.setStroke(new BasicStroke(4));
		g2.drawRect(x1, y1, w1, h1);
		if(selectedCircle)
			g2.setColor(Color.yellow);
		else
			g2.setColor(Color.black);
		g2.fillOval(x3, y3, w3, h3);
		g2.setColor(Color.gray);
		g2.drawOval(x3, y3, w3, h3);
		
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(800,600);
		
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("My first bad game");
		frame.add(new ArrowKeysGame());
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
		if(isInRectangle(x1, y1, w1, h1, xm, ym))
		{
			x1 = (int) (Math.random() * (PANEL_WIDTH - w1));
			y1 = (int) (Math.random() * (PANEL_HEIGHT - h1));
			score = 0;
		}
	}
	@Override
	public void mouseReleased(MouseEvent e)
	{
		selectedRect = false;
		selectedRect2 = false;
		selectedCircle = false;
		repaint();
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
	}
	@Override
	public void mouseMoved(MouseEvent e)
	{
		int xm = e.getX();
		int ym = e.getY();
		//Check if mouse is in rectangle
		if(isInRectangle(x1, y1, w1, h1, xm, ym))
			selectedRect = true;
		else
			selectedRect = false;
		//Check if mouse is in circle
		if(isInCircle(x3, y3, w3, h3, xm, ym))
			selectedCircle = true;
		else
			selectedCircle = false;
		if(isInCircle(x3, y3, w3, h3, xm, ym)) 
		{
			w3 = (int) (Math.random() * 181 + 20);
			h3 = w3;
			x3 = (int) (Math.random() * (PANEL_WIDTH - w3));
			y3 = (int) (Math.random() * (PANEL_HEIGHT - h3));
			score++;
			if(!isInCircle(x3, y3, w3, h3, xm, ym))
				selectedCircle = false;
		}
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
        System.out.println("Key Typed");
	}
	@Override
	public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed");
        int keyPressed = e.getKeyCode();
        System.out.println(keyPressed);
        
        if(keyPressed == 39) right = true;
        else if(keyPressed == 37) left = true;
        else if(keyPressed == 38) up = true;
        else if(keyPressed == 40) down = true;
	}
	@Override
	public void keyReleased(KeyEvent e) {
        int keyPressed = e.getKeyCode();
        if(keyPressed == 39) right = false;
        else if(keyPressed == 37) left = false;
        else if(keyPressed == 38) up = false;
        else if(keyPressed == 40) down = false;
	}
}