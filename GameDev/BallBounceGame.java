package GameDev;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.Timer;
import java.awt.RenderingHints;

public class BallBounceGame extends JPanel implements KeyListener, MouseMotionListener, MouseListener {
    public static final int PERF_W = 800;
    public static final int PERF_H = 600;
    public int ballX, ballY, ballW, ballH;
    
    // Physics variables
    private double velocityX = 0;
    private double velocityY = 0;
    private int mouseX = PERF_W / 2;
    private int mouseY = PERF_H / 2;
    private final double springFactor = 0.05; // How strongly the ball is attracted to mouse
    private final double dampingFactor = 0.9; // How quickly the ball slows down (0-1)

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // Set up anti-aliasing
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        
        g2.setColor(new Color(120,50,140));
        g2.setFont(new Font("Benguiat", Font.PLAIN, 42));
        // g2.drawString("SIGMA BOY", 100, 100);

        // Make a ball that will move around the screen like a physics object
        g2.setColor(Color.RED);
        g2.fillOval(ballX, ballY, ballW, ballH);

    }


    public BallBounceGame(){
        System.out.println("Constructing game panel.");
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.setFocusable(true);
        
        // Initialize ball properties
        ballX = PERF_W / 2;
        ballY = PERF_H / 2;
        ballW = 30;
        ballH = 30;

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Physics calculation
                double dx = mouseX - (ballX + ballW/2);
                double dy = mouseY - (ballY + ballH/2);
                
                // Apply spring force
                velocityX += dx * springFactor;
                velocityY += dy * springFactor;
                
                // Apply damping
                velocityX *= dampingFactor;
                velocityY *= dampingFactor;
                
                // Update position
                ballX += velocityX;
                ballY += velocityY;
                
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
        frame.add(new BallBounceGame());
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
        // TODO Auto-generated method stub
        int key = e.getKeyCode();
        System.out.println("Pressed " + key);
    }


    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    // Mouse motion listener methods
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }
    
    // Mouse listener methods
    @Override
    public void mousePressed(MouseEvent e) {}
    
    @Override
    public void mouseReleased(MouseEvent e) {}
    
    @Override
    public void mouseClicked(MouseEvent e) {}
    
    @Override
    public void mouseEntered(MouseEvent e) {}
    
    @Override
    public void mouseExited(MouseEvent e) {}
}
