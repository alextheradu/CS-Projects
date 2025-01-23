import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
   
//Honors Computer Science - Alex Radu
//Program Description: Building a Snowman on a Java Panel

public class Snowyman extends JPanel implements MouseListener, MouseMotionListener, KeyListener
{
   //Variables for the class
   private static final long serialVersionUID = 1L;
   public static final int PREF_W = 800;
   public static final int PREF_H = 600;
   private int xc1 = 0;
   private int xc2 = 500;
   private boolean left, right, up, down;
   private ArrayList<Integer> xList = new ArrayList<Integer>();
   private ArrayList<Integer> yList = new ArrayList<Integer>();
   private boolean isFacingRight;
   private List<Integer> pressedKeys = new ArrayList<>();
   private int jesseX, jesseY, jesseW, jesseH;
   
   private Snowflake s1;

   //Class constructor
   public Snowyman()
   {
      this.setFocusable(true);
      this.setBackground(Color.WHITE);
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
      this.addKeyListener(this);

      s1 = new Snowflake(300, 50, 20, 20, 1, 1);

      jesseX = jesseY = 0;
      jesseW = jesseH = 50;
      Timer timer = new Timer(75, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) 
				{
               xc1+=2;
               xc2+=2;
               //make it so if the clouds go off screen, they go to the other side
               if(xc1 > 800)
                  xc1 = -200;
               if(xc2 > 800)
                  xc2 = -200;

               if(left) jesseX-=3;
               if(right) jesseX+=3;
               if(up) jesseY-=3;
               if(down) jesseY+=3;
               if(jesseX > PREF_W)
                  jesseX = -jesseW;
               if(jesseY > PREF_H)
                  jesseY = -jesseH;
               if(jesseX < -jesseW)
                  jesseX = PREF_W;
               if(jesseY < -jesseH)
                  jesseY = PREF_H;
					repaint();

				}
			});
			timer.start();
      }
   
   //The method used to add graphical images to the panel
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
       
      Graphics2D g2 = (Graphics2D) g;

      g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON));
      g2.setStroke(new BasicStroke(4));

      //draw blue sky (light gradient)
      g2.setColor(new Color(0, 191, 255));
      g2.fillRect(0, 0, 800, 600);
      //draw sidewalk
      g2.setColor(Color.darkGray);
      g2.fillRect(0, 400, 800, 200);
      //draw sun
      g2.setColor(Color.YELLOW);
      g2.fillOval(700, -100, 200, 200);
      g2.setColor(Color.BLACK);
      g2.drawOval(700, -100, 200, 200);
      //draw cloud1
      g2.setColor(Color.WHITE);
      g2.fillOval(xc1, 50, 100, 50);
      g2.fillOval(xc1 + 20, 70, 100, 50);
      g2.fillOval(xc1 + 40, 50, 100, 50);
      g2.fillOval(xc1 + 60, 70, 100, 50);
      g2.fillOval(xc1 + 80, 50, 100, 50);
      //draw cloud2
      g2.fillOval(xc2, 100, 100, 50);
      g2.fillOval(xc2 + 20, 120, 100, 50);
      g2.fillOval(xc2 + 40, 100, 100, 50);
      g2.fillOval(xc2 + 60, 120, 100, 50);
      g2.fillOval(xc2 + 80, 100, 100, 50);
      //draw tree1
      int[] xs9 = {639, 639, 482, 577, 577, 493, 581, 581, 515, 643, 643, 787, 787, 737, 794, 745, 793, 793, 690, 690};
      int[] ys9 = {464, 464, 480, 335, 335, 345, 223, 223, 224, 97, 97, 219, 219, 223, 338, 342, 477, 477, 464, 464};
      g2.setColor(new Color(23, 112, 11));
      g2.fillPolygon(xs9, ys9, xs9.length);
      g2.setColor(Color.BLACK);
      g2.drawPolygon(xs9, ys9, xs9.length);
      //draw tree2
      int[] xs11 = {142, 7, 53, 29, 64, 64, 47, 47, 118, 118, 181, 181, 165, 196, 177, 225};
      int[] ys11 = {338, 331, 292, 285, 243, 243, 241, 241, 162, 162, 232, 232, 235, 269, 274, 337};
      g2.setColor(new Color(23, 112, 11));
      g2.fillPolygon(xs11, ys11, xs11.length);
      g2.setColor(Color.BLACK);
      g2.drawPolygon(xs11, ys11, xs11.length);
      //draw tree1 stump
      int[] xs12 = {689, 641, 641, 699};
      int[] ys12 = {461, 463, 540, 539};
      g2.setColor(new Color(139, 69, 19));
      g2.fillPolygon(xs12, ys12, xs12.length);
      g2.setColor(Color.BLACK);
      g2.drawPolygon(xs12, ys12, xs12.length);
      //draw tree2 stump
      int[] xs13 = {128, 128, 128, 85, 87};
      int[] ys13 = {340, 401, 401, 402, 338};
      g2.setColor(new Color(139, 69, 19));
      g2.fillPolygon(xs13, ys13, xs13.length);
      g2.setColor(Color.BLACK);
      g2.drawPolygon(xs13, ys13, xs13.length);
      //Draw snowflakes
      s1.draw(g2);
      //Bottom snowball
      g2.setColor(Color.BLACK);
      g2.drawOval(275, 350, 250, 220);
      g2.setColor(Color.WHITE);
      g2.fillOval(275, 350, 250, 220);
      //Middle snowball
      g2.setColor(Color.BLACK);
      g2.drawOval(305, 225, 190, 175);
      g2.setColor(Color.WHITE);
      g2.fillOval(305, 225, 190, 175);
      //Head
      g2.setColor(Color.BLACK);
      g2.drawOval(340, 140, 120, 120);
      g2.setColor(Color.WHITE);
      g2.fillOval(340, 140, 120, 120);
      //draw nametag (waltuh white)
      g2.setColor(Color.BLACK);
      g2.drawString("Waltuh White", 325, 285);
      g2.drawRect(320, 270, 90, 20);
      //Hat brim
      g2.setColor(Color.black);
      g2.fillOval(300, 130, 200, 30);
      //Hat
      g2.fillRect(350, 50, 100, 90);
      //Hat top
      g2.fillOval(350, 43, 100, 16);
      //Sunglasses/glasses
      g2.setColor(Color.BLACK);
      g2.fillRect(360, 190, 25, 25);
      g2.fillRect(410, 190, 25, 25);
      g2.fillRect(385, 195, 30, 5);
      g2.drawLine(360, 190, 350, 185);
      g2.drawLine(435, 190, 445, 185);
      //Eyes
      g2.setColor(Color.BLACK);
      g2.fillOval(365, 190, 15, 15);
      g2.fillOval(415, 190, 15, 15);
      //Mouth
      g2.fillOval(350, 150, 15, 10);

      
      //Draw beard (waltuh white)
      int[] xs3 = {374, 375, 377, 378, 379, 381, 382, 382, 383, 383, 384, 384, 386, 388, 390, 391, 393, 394, 397, 398, 399, 400, 401, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 414, 415, 416, 416, 417, 417, 417, 417, 417, 417, 417, 417, 417, 417, 417, 417, 417, 417, 417, 418, 418, 418, 418, 418, 418, 418, 418, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 419, 418, 418, 418, 417, 417, 416, 415, 414, 413, 412, 411, 411, 410, 409, 408, 407, 406, 405, 404, 404, 403, 402, 401, 400, 399, 398, 398, 397, 396, 395, 395, 394, 394, 393, 392, 392, 391, 390, 390, 389, 389, 388, 387, 387, 386, 385, 384, 383, 382, 381, 380, 379, 379, 378, 377, 377, 376, 376, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375, 375};
      int[] ys3 = {226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 226, 227, 227, 227, 228, 228, 228, 229, 229, 230, 230, 230, 231, 231, 231, 232, 232, 232, 233, 233, 234, 234, 235, 235, 235, 236, 236, 236, 237, 237, 238, 238, 239, 239, 239, 240, 241, 241, 242, 242, 243, 243, 244, 244, 245, 245, 246, 246, 246, 247, 247, 247, 248, 248, 249, 249, 249, 250, 250, 251, 251, 252, 253, 253, 254, 254, 255, 255, 256, 256, 257, 257, 257, 257, 257, 258, 258, 259, 259, 259, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 260, 259, 259, 259, 259, 258, 258, 258, 257, 257, 256, 256, 255, 255, 254, 253, 253, 252, 251, 250, 249, 249, 248, 247, 246, 245, 244, 243, 242, 241, 240, 239, 239, 238, 238, 237, 236, 236, 236, 235, 235, 235, 234, 234, 233, 233, 232, 232, 231, 231, 231, 230, 230, 229, 229, 229, 228, 228, 228, 228, 227, 227};
      g2.setColor(new Color(75, 45, 30));
      g2.fillPolygon(xs3, ys3, xs3.length);
      g2.setColor(Color.BLACK);
      g2.drawPolygon(xs3, ys3, xs3.length);
      //Draw mouth (waltuh white)
      int[] xs4 = {385, 408};
      int[] ys4 = {239, 238};
      g2.setColor(Color.GRAY);
      g2.fillPolygon(xs4, ys4, xs4.length);
      g2.setColor(Color.BLACK);
      g2.drawPolygon(xs4, ys4, xs4.length);
      //draw left arm
      int[] xs5 = {311, 182, 182, 158, 158, 158, 177, 164, 164, 172, 182, 182, 181, 192, 192, 247, 247, 247, 252, 252, 308};
      int[] ys5 = {274, 304, 304, 303, 303, 311, 311, 321, 321, 323, 316, 316, 329, 329, 318, 304, 310, 310, 310, 305, 290};
      g2.setColor(Color.GRAY);
      g2.fillPolygon(xs5, ys5, xs5.length);
      g2.setColor(Color.BLACK);
      g2.drawPolygon(xs5, ys5, xs5.length);
      //draw candy bag
      int[] xs6 = {193, 191, 184, 180, 176, 171, 169, 167, 165, 160, 157, 152, 150, 149, 146, 144, 141, 140, 137, 133, 132, 131, 131, 131, 131, 131, 131, 131, 131, 131, 131, 131, 130, 130, 130, 130, 129, 129, 129, 128, 128, 128, 128, 127, 127, 127, 126, 126, 126, 126, 126, 126, 126, 126, 126, 126, 126, 126, 126, 126, 126, 126, 126, 126, 127, 129, 132, 135, 139, 142, 146, 151, 155, 159, 164, 168, 171, 174, 177, 179, 181, 182, 184, 186, 189, 192, 195, 198, 200, 203, 205, 208, 210, 212, 214, 215, 216, 218, 219, 221, 222, 223, 223, 223, 223, 222, 221, 220, 218, 217, 215, 214, 214, 213, 213, 213, 213, 213, 213, 213, 213, 213, 213, 213, 213, 213, 214, 214, 215, 215, 215, 215, 215, 215, 215, 214, 214, 213, 213, 212, 211, 210, 210, 209, 208, 208, 207, 206, 205, 204, 202, 201, 200, 199, 198, 196, 195, 193, 192, 191, 189, 188, 187, 186, 185, 184, 183, 182, 181, 180, 179, 178, 177, 177, 176, 175, 175, 174, 174, 174, 172, 171, 169, 168, 167, 166, 165, 164, 164, 163, 162, 161, 160, 160, 159, 158, 158, 157, 157, 156, 155, 154, 153, 152, 151, 150, 149, 148, 147, 146, 146, 146, 145, 145, 143, 141, 139, 138, 137, 137, 136, 136, 136, 135, 135, 134, 134, 133, 133, 133, 132, 132, 132, 131, 131, 131, 131, 131, 131, 131, 131, 131, 131, 131, 131, 130, 130, 130, 130, 130, 130, 130, 130, 130, 130, 131, 132, 134, 136, 138, 141, 144, 148, 151, 155, 159, 163, 167, 170, 173, 175, 177, 178, 180, 181, 183, 185, 187, 189, 191, 193, 194, 195, 197, 198, 199, 200, 202, 203, 203, 204, 205, 205, 206, 207, 207, 208, 209, 209, 209, 210, 210, 210, 210, 211, 211, 211, 212, 212, 212, 212, 212, 215};
      int[] ys6 = {316, 316, 316, 316, 316, 316, 316, 316, 316, 316, 316, 316, 316, 316, 316, 316, 316, 316, 316, 316, 316, 316, 316, 316, 316, 317, 317, 318, 319, 320, 322, 324, 326, 328, 330, 332, 334, 337, 339, 341, 342, 343, 345, 347, 349, 350, 352, 355, 357, 359, 361, 362, 364, 365, 366, 367, 368, 369, 370, 370, 371, 371, 371, 371, 371, 370, 370, 369, 369, 369, 369, 369, 368, 368, 367, 366, 366, 365, 364, 364, 363, 363, 363, 363, 363, 363, 362, 362, 362, 362, 361, 361, 361, 361, 361, 361, 361, 361, 361, 361, 361, 361, 361, 360, 360, 360, 359, 358, 357, 356, 355, 354, 353, 352, 351, 349, 347, 345, 343, 341, 339, 337, 336, 335, 332, 329, 325, 321, 318, 317, 316, 315, 315, 315, 315, 315, 315, 315, 315, 315, 316, 316, 316, 316, 316, 317, 317, 317, 317, 317, 317, 317, 317, 318, 318, 318, 318, 318, 318, 318, 318, 318, 318, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 320, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 319, 320, 320, 320, 321, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330, 330, 331, 331, 332, 332, 332, 332, 332, 331, 331, 331, 331, 331, 331, 331, 331, 331, 331, 331, 331, 331, 331, 331, 331, 331, 331, 331, 331, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 332, 318};
      g2.setColor(Color.BLACK);
      g2.drawPolygon(xs6, ys6, xs6.length);
      
      //draw candy
      int[] xs7 = {127, 130, 134, 137, 140, 142, 143, 144, 145, 146, 149, 151, 152, 154, 155, 156, 157, 159, 160, 161, 162, 163, 164, 166, 167, 168, 169, 170, 171, 172, 174, 175, 176, 177, 178, 179, 181, 182, 182, 183, 184, 185, 186, 188, 190, 191, 192, 193, 193, 194, 195, 196, 198, 199, 199, 200, 201, 201, 202, 202, 203, 203, 203, 204, 204, 205, 206, 206, 206, 207, 207, 207, 207, 208, 208, 208, 209, 209, 209, 209, 209, 210, 210, 211, 211, 212, 212, 213, 213, 213, 213, 213, 213, 213, 213, 214, 214, 214, 214, 214, 214, 215, 215, 215, 215, 216, 216, 216, 216, 216, 216, 217, 217, 217, 217, 217, 217, 217, 218, 218, 218, 218, 218, 218, 219, 219, 219, 219, 219, 219, 219, 220, 220, 220, 220, 220, 220, 219, 218, 217, 216, 215, 214, 213, 213, 212, 211, 211, 210, 210, 209, 209, 208, 208, 208, 207, 207, 207, 206, 205, 205, 204, 204, 203, 203, 202, 201, 200, 199, 198, 197, 196, 195, 195, 195, 194, 194, 194, 194, 193, 193, 193, 192, 192, 191, 191, 190, 190, 189, 188, 188, 187, 186, 185, 184, 183, 183, 182, 182, 181, 181, 180, 180, 180, 179, 179, 178, 178, 177, 176, 176, 175, 175, 174, 174, 173, 173, 172, 172, 171, 170, 169, 168, 166, 165, 163, 162, 162, 161, 160, 159, 158, 157, 156, 155, 154, 154, 153, 152, 151, 150, 150, 149, 148, 147, 146, 145, 144, 143, 142, 141, 141, 140, 139, 138, 137, 137, 136, 136, 135, 135, 135, 134, 134, 134, 133, 133, 133, 132, 132, 131, 131, 130, 130, 129, 129, 128, 128, 128, 128, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 128, 128, 128, 128, 128, 128, 128};
      int[] ys7 = {347, 346, 345, 345, 344, 344, 343, 343, 343, 343, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 342, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 343, 344, 344, 344, 344, 345, 345, 346, 347, 347, 348, 348, 349, 349, 349, 349, 350, 350, 350, 350, 351, 351, 351, 351, 352, 352, 352, 353, 353, 353, 354, 354, 354, 355, 355, 355, 355, 356, 356, 356, 356, 357, 357, 357, 358, 358, 358, 358, 359, 359, 360, 360, 360, 360, 361, 361, 361, 361, 361, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 363, 363, 364, 364, 364, 364, 365, 365, 365, 366, 366, 366, 366, 366, 366, 366, 366, 366, 366, 367, 367, 367, 367, 367, 367, 367, 367, 367, 367, 367, 367, 367, 367, 367, 367, 368, 368, 368, 368, 368, 368, 368, 368, 368, 368, 368, 368, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 369, 368, 368, 367, 367, 366, 366, 365, 364, 364, 363, 362, 362, 361, 360, 360, 359, 359, 358, 358, 357, 357, 356, 355, 354, 354, 353, 353, 352, 351, 350, 349, 348, 348, 347, 347, 346, 346, 345, 345};
      g2.setColor(new Color(0, 255, 255));
      g2.fillPolygon(xs7, ys7, xs7.length);
      g2.setColor(Color.BLACK);
      g2.drawPolygon(xs7, ys7, xs7.length);
      
      // //draw rigt arm
      int[] xs8 = {485, 593, 594, 594, 604, 602, 620, 620, 604, 490};
      int[] ys8 = {272, 251, 223, 223, 223, 246, 248, 257, 257, 283};
      g2.setColor(Color.GRAY);
      g2.fillPolygon(xs8, ys8, xs8.length);
      g2.setColor(Color.BLACK);
      g2.drawPolygon(xs8, ys8, xs8.length);
      
      //draw file(2).png 
      Image jessePic = new ImageIcon(this.getClass().getResource("file (2).png")).getImage();
      g2.drawImage(jessePic, jesseX, jesseY, jesseW, jesseH, this);


      //Draw the experimental polygon
      if(xList.size() >= 1)
      {
         for(int i = 0; i < xList.size()-1; i++)
         {
            g2.drawLine(xList.get(i), yList.get(i), xList.get(i+1), yList.get(i+1));
         }
      }
   }
   
   
/** *******  METHODS FOR INITIALLY CREATING THE JFRAME AND JPANEL  *********/

   public Dimension getPreferredSize()
   {
      return new Dimension(PREF_W, PREF_H);
   }
   
   public static void createAndShowGUI()
   {
      JFrame frame = new JFrame("Do You Want to Build a Snowman? (Amazing Project by: Alex Radu)");
      JPanel gamePanel = new Snowyman();
      
      frame.getContentPane().add(gamePanel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
   
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }

   @Override
   public void mouseClicked(MouseEvent e) {}
   
   @Override
   public void mousePressed(MouseEvent e)
   {
   }
   
   @Override
   public void mouseReleased(MouseEvent e)
   {
      //Add the x and y coordinates to the ArrayLists
      xList.add(e.getX());
      yList.add(e.getY());
   
      if(xList.size() >= 1)
      {
   
         System.out.println("xList.add(" + e.getX() + ");");
         System.out.println("yList.add(" + e.getY() + ");");
         
         int listNum = 3;
         //Print out the x and y coordinates
         System.out.print("int[] xs" + listNum + " = {");
         for(int i=0; i < xList.size()-1; i++)
            System.out.print(xList.get(i) + ", ");
         //Print out the last x coordinate
         System.out.println(xList.get(xList.size()-1) + "};");
         //Print out the y coordinates
         System.out.print("int[] ys" + listNum + " = {");
         for(int i=0; i < yList.size()-1; i++)
            System.out.print(yList.get(i) + ", ");
         //Print out the last y coordinate
         System.out.println(yList.get(yList.size()-1) + "};");
         //Print out the code to draw the polygon
         System.out.println("g2.setColor(Color.GRAY);");
         System.out.println("g2.fillPolygon(xs" + listNum + ", ys" + listNum + ", xs" + listNum + ".length);");
         System.out.println("g2.setColor(Color.BLACK);");
         System.out.println("g2.drawPolygon(xs" + listNum + ", ys" + listNum + ", xs" + listNum + ".length);");
         repaint();
      }
   }

   @Override
   public void mouseEntered(MouseEvent e) {}

   @Override
   public void mouseExited(MouseEvent e) {}

   @Override
   public void mouseDragged(MouseEvent e) 
   {
      //make a ghost-line which is only shown if the mouse is dragged
      xList.add(e.getX());
      yList.add(e.getY());
      repaint();

   }

   @Override
   public void mouseMoved(MouseEvent e)
   {
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

   @Override
   public void keyTyped(KeyEvent e) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
   }
}