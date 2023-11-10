package OOPS.Inheritance;

public class Box {
    protected double h;
    protected double w;
    protected double l;

    public Box() {
        this.h = -1;
        this.w = -1;
        this.l = -1;
    }
    public Box(Box box){
        this.h = box.h;
        this.w = box.w;
        this.l = box.l;
    }

    public Box(double h, double w, double l) {
        this.h = h;
        this.w = w;
        this.l = l;
    }
}
