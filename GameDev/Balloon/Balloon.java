package GameDev.Balloon;

import java.awt.Color;

public class Balloon {
    private int diameter;
    private Color color;

    public Balloon(Color c, int d) {
        this.diameter = d;
        this.color = c;
    }

    public void setDiameter(int d) {
        this.diameter = d;
    }
    public void setColor(Color c) {
        this.color = c;
    }

    public int getDiameter() {
        return this.diameter;
    }
    public Color getColor() {
        return this.color;
    }

    public String toString() {
        return "Balloon [diameter=" + diameter + ", color=" + color + "]";
    }

}
