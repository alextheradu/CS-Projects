import java.awt.Color;

//Alex Radu
//Jan 23, 2025

public class Snowflake {
	//Define variable to represent a snowflake
   private int x, y, w, h;
   private double dy, dx, speed;

   //Constructor
   public Snowflake(int x, int y, int w, int h, double dy) {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      this.dy = dy;
   }
   public Snowflake(int x, int y, int w, int h, double dy, double speed) {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      this.dy = dy;
      this.speed = speed;
   }
   public Snowflake(int x, int y, int w, int h, double dy, double dx, double speed) {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      this.dy = dy;
      this.dx = dx;
      this.speed = speed;
   }
   public void draw(Graphics2D g2) {
      g2.setColor(Color.WHITE);
      g2.fillOval(x, y, w, h);
   }
}