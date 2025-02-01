import java.awt.Color;
import java.awt.Graphics2D;
//Alex Radu
//Jan 23, 2025

public class Snowflake {
	//Define variable to represent a snowflake
   private int x, y, w, h;
   private double dy, dx, speed;
   private Color color;

   //Constructor
   public Snowflake(int x, int y, int w, int h, double dy) {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      this.dy = dy;
      color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
   }
   public Snowflake(int x, int y, int w, int h, double dy, double speed) {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      this.dy = dy;
      this.speed = speed;
      color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
   }
   public Snowflake(int x, int y, int w, int h, double dy, double dx, double speed) {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      this.dy = dy;
      this.dx = dx;
      this.speed = speed;
      color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
   }

   //Methods... Methods are functions that apply to each object of the class.

   public void draw(Graphics2D g2) {
      g2.setColor(color);
      g2.fillOval((int) x, (int) y, w, h);
   }
   public void fall(int PREF_H, int PREF_W) {
      y += speed;  // Use the speed parameter instead of dy
      if(y > (PREF_H) - 150) {
         y = -20;
         x = (int) (Math.random() * 800);
         // Optionally randomize speed when resetting position
         speed = (Math.random() * 4) + 1;  // Random speed between 1-5
      }
      System.out.println("Falling: " + x + ", " + y + ", " + dx + ", dy");
   }
}