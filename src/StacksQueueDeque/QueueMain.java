package StacksQueueDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

public class QueueMain {
    public static void main(String[] args)throws Exception {
//        List<Integer> a = new List<>();
        DynamicQue queue = new DynamicQue(5);
        queue.insert(12);
        queue.insert(14);
        queue.insert(16);
        queue.insert(18);
        queue.insert(19);
        queue.display();

        queue.insert(24);
        queue.insert(26);

        queue.display();
        System.out.println(queue.size);
        System.out.println(queue.end);
        System.out.println(queue.front);
        System.out.println(Arrays.toString(queue.data));

    }
}
