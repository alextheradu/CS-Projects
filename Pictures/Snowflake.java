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
      color = Color.white;
   }
   
   public void changeColor() {
      color = Color.RED;
   }
   public Snowflake(int x, int y, int w, int h, double dy, double speed) {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      this.dy = dy;
      this.speed = speed;
      color = Color.white;
   }
   public Snowflake(int x, int y, int w, int h, double dy, double dx, double speed) {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      this.dy = dy;
      this.dx = dx;
      this.speed = speed;
      color = Color.white;
   }

   //Methods... Methods are functions that apply to each object of the class.

   public void draw(Graphics2D g2) {
      g2.setColor(color);
      g2.fillRect((int) x, (int) y, w, h);
   }
   public void fallSideways (int PREF_H, int PREF_W) {
      y += speed;  // Use the speed parameter instead of dy
      x += speed;
      if(y > (PREF_H)) {
         y = -20;
         x = (int) (Math.random() * 800) - 200;
         // Optionally randomize speed when resetting position
         // speed = (Math.random() * 4) + 1;  // Random speed between 1-5
      }
      if(x > (PREF_W)) {
         y = -20;
         x = (int) (Math.random() * 800) - 200;
         // Optionally randomize speed when resetting position
         // speed = (Math.random() * 4) + 1;  // Random speed between 1-5
      }
   }
   public void fall(int PREF_H, int PREF_W) {
      y += speed;  // Use the speed parameter instead of dy
      if(y > (PREF_H) - 150) {
         y = -20;
         x = (int) (Math.random() * 800);
         // Optionally randomize speed when resetting position
         // speed = (Math.random() * 4) + 1;  // Random speed between 1-5
      }
      // System.out.println("Falling: " + x + ", " + y + ", " + dx + ", dy");
   }

   public void increaseSpeed() {
      speed = 1.2 * speed;
   }

   public void decreaseSpeed() {
      speed = (double) 0.8 * speed;
      if(speed <= 1) {
         speed = 1;
      } 
   }
   
   public double getSpeed() {
      return speed;
   }
   public void setColor(Color color) {
      this.color = color;
   }
}