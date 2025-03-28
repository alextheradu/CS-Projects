package GameDev;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.awt.RenderingHints;

public class GamePanelTemplate extends JPanel implements KeyListener {
    public static final int PERF_W = 800;
    public static final int PERF_H = 600;
    public int ballX, ballY, ballW, ballH;
    public int ballSpeed = 1;
    
    // Add boolean variables to track key states
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        g2.setColor(new Color(120,50,140));
        g2.setFont(new Font("Benguiat", Font.PLAIN, 42));
        g2.drawString("Hello World", 100, 100);

        g2.setStroke(new BasicStroke(3));
        // Make a ball that will move around the screen like a physics object
        g2.setColor(Color.RED);
        g2.fillOval(ballX, ballY, ballW, ballH);
        // Add outline to ball
        g2.setColor(Color.BLACK);
        g2.drawOval(ballX, ballY, ballW, ballH);
        

    }

    public GamePanelTemplate(){
        System.out.println("Constructing game panel.");
        this.addKeyListener(this);
        this.setFocusable(true);
        
        // Initialize ball properties
        ballW = 30;
        ballH = 30;
        ballX = PERF_W / 2 - ballW / 2;
        ballY = PERF_H / 2 - ballH / 2;

        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(left) ballX -= ballSpeed;
                if(right) ballX += ballSpeed;
                if(up) ballY -= ballSpeed;
                if(down) ballY += ballSpeed;
                
                // Make the ball pass through to the other side
                if(ballX > PERF_W) ballX = 0;
                if(ballX < -15) ballX = PERF_W;
                if(ballY > PERF_H) ballY = 0;
                if(ballY < -15) ballY = PERF_H;
                
                repaint();
            }
        });
        timer.start();
    }
    public Dimension getPreferredSize() {
        return new Dimension(PERF_W, PERF_H);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel Template");
        frame.add(new GamePanelTemplate());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println("Pressed " + key);
        
        // Set boolean flags based on key presses
        if (key == KeyEvent.VK_UP) {
            up = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        // Reset boolean flags when keys are released
        if (key == KeyEvent.VK_UP) {
            up = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            down = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = false;
        }
    }
}