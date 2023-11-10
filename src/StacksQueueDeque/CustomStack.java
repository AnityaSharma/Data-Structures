package StacksQueueDeque;

import java.util.Queue;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size){
        data = new int[size];
    }
    public boolean push(int item){
        if (isFull()){
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop()throws StackException{
        if(isEmpty()) {
            throw new StackException("Can not pop from an empty stack");
        }
        int content = data[ptr];
        ptr--;
        return content;
    }
    public boolean isFull(){
        if (ptr == data.length-1){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        if (ptr == -1){
            return true;
        }
        return false;
    }
    public int peek()throws StackException{
        if(isEmpty()) {
            throw new StackException("Can not peek from an empty stack");
        }
        return data[ptr];
    }



}
