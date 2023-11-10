package Trees;

import java.io.OutputStream;

public class MainClass {
    public static void main(String[]args){
        AvlTree tree=new AvlTree();
        int[] arr={13, 3, 4, 12, 14, 10, 5, 1, 8, 2, 7, 9, 11, 6, 18};
        tree.populate(arr);
        tree.display();
    }
}
