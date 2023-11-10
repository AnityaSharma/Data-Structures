package StacksQueueDeque;

public class CustomQueue {
    private int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int end = 0;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }
    public CustomQueue(int size){
        data = new int[size];
    }
    public boolean isFull(){
        if (end == data.length){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        if (end == 0){
            return true;
        }
        return false;
    }
    public boolean insert(int item){
        if (isFull()){
            System.out.println("Queue is full");
            return false;
        }
        data[end] = item;
        end++;
        return true;
    }
    public int remove()throws StackException{
        if (isEmpty()) {
            throw new StackException("Queue is empty");
        }
        int removed = data[0];
        for (int i = 1;i<end;i++){
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }
    public int front()throws StackException{
        if (isEmpty()) {
            throw new StackException("Queue is empty");
        }
        return data[0];
    }
    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println("END");
    }
}
