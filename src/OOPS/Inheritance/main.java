package OOPS.Inheritance;

public class main {
    public static void main(String[] args) {
        Box box = new Box();
        System.out.println(box.h+" "+box.l+" "+box.w);
        Box box1 = new Box(4,10,12);
        System.out.println(box1.h+" "+box1.l+" "+box1.w);

        BoxWeight bw = new BoxWeight(4,10,12,30);
        System.out.println(bw.h+" "+bw.l+" "+bw.w+" "+bw.weight);




    }
}
