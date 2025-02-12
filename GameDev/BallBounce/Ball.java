package GameDev.BallBounce;

public class Ball {
    private double x, y;
    private int w, h;

    public Ball(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    // Getters
    public double getX() { return x; } public double getY() { return y; } public int getW() { return w; } public int getH() { return h; } 
    // Setters
    public void setX(double x) { this.x = x; } public void setY(double y) { this.y = y; } public void setW(int w) { this.w = w; } public void setH(int h) { this.h = h; }
    // toString
    public String toString () {
        return "Ball [x=" + x + ", y=" + y + ", w=" + w + ", h=" + h + "]";
    }
}
