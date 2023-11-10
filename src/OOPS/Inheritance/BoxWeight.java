package OOPS.Inheritance;

public class BoxWeight extends Box{
    double weight;
    public BoxWeight(BoxWeight box){
        super(box);
        this.weight = box.weight;
    }

    public BoxWeight(double h, double w, double l, double weight) {
        super(h, w, l);
        this.weight = weight;
    }
}
