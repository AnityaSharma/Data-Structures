package LinkedList;

public class DLL {

    private Node head;
    private int size;

    public DLL(){
        this.size = 0;
    }
    public void insert(int value,int index){
        if (index == 0){
            insertFirst(value);
            return;
        }
        if(index == size){
            insertLast(value);
        }

        Node node = new Node(value);
        Node temp = head;
        for (int i = 1; i < index ; i++) {
            temp = temp.next;
        }

        node.prev = temp;
        node.next = temp.next;
        temp.next.prev = node;
        temp.next=node;
        size++;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null ){
            head.prev = node;
        }
        head = node;
        size++;
    }
    public void display(){
        Node temp = head;
        Node last = null;
        while(temp != null){
            System.out.print(temp.val+" -> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("END");

        while(last != null){
            System.out.print(last.val+" -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    public void insertLast(int val){
        Node node = new Node(val);
        Node temp = head;

        node.next = null;

        if (head == null){
            node.prev = null;
            head = node;
            size++;
            return;
        }

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = node;
        node.prev = temp;
        size++;
    }

    public void displayRev(){
        Node temp = head;
        while(temp != null){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        while(temp != null){
            System.out.print(temp.val +" -> ");
            temp = temp.prev;
        }
        System.out.println("END");
    }

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

    }
}
