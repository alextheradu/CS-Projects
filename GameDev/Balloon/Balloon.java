package GameDev.Balloon;

import java.awt.Color;

public class Balloon implements Comparable<Balloon> {
    private static int nextId = 1;
    private int id;
    private int diameter;
    private Color color;

    public Balloon(Color c, int d) {
        this.id = nextId++;
        this.diameter = d;
        this.color = c;
    }

    public void setDiameter(int d) {
        this.diameter = d;
    }
    public void setColor(Color c) {
        this.color = c;
    }

    public int getId() {
        return this.id;
    }
    public int getDiameter() {
        return this.diameter;
    }
    public Color getColor() {
        return this.color;
    }

    public String toString() {
        return "Balloon [id=" + id + ", diameter=" + diameter + ", color=" + color + "]";
    }


    @Override
    public int compareTo(Balloon other) {
        if(this.diameter < other.diameter)
            return -1;
        else if(this.diameter > other.diameter)
            return 1;
        else
        return 0;
    }
}
