package StacksQueueDeque;

public class CircularQue {
    protected int[] data;
    protected int front = 0;
    protected int end = 0;

    protected int size = 0;

    protected static final int DEFAULT_SIZE = 10;
    CircularQue(){
        this(DEFAULT_SIZE);
    }
    CircularQue(int size){
        data = new int[size];
    }
    public boolean isFull(){
        return size == data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean insert(int item){
        if (isFull()){
            System.out.println("Queue is full");
            return false;
        }
        end = end % data.length;
        data[end] = item;
        end++;
        size++;
        return true;
    }
    public int remove()throws StackException{
        if (isEmpty()) {
            throw new StackException("Queue is empty");
        }
        int removed = data[front];
        front++;
        front = front % data.length;
        size--;
        return removed;
    }
    public int front()throws StackException{
        if (isEmpty()) {
            throw new StackException("Queue is empty");
        }
        return data[front];
    }
    public void display(){
        int sizetemp = size;
        int i = front;
        while(sizetemp != 0){
            i = i % data.length;
            System.out.print(data[i]+" ");
            sizetemp--;
            i++;
        }
        System.out.println("END");
    }
}
