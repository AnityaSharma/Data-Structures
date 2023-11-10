import StacksQueueDeque.QueueMain;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        don(10);
        Queue<Integer> q = new LinkedList<>();

    }

    static void don(int n){
        if(n==1){
            System.out.print(1+" ");
            return;
        }
        don(n-1);
        System.out.print(n+" ");
    }
}