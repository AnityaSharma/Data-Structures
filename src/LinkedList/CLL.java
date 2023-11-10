package LinkedList;

public class CLL {

    private Node head;
    private Node tail;

    private int size;

    public void delete(int val){
        Node temp = head;
        if( head == null){
            System.out.println("CLL is empty");
            return;
        }

        if (head.val==val){
            head = head.next;
            tail.next = head;
            size--;
            return;
        }
        temp = temp.next;

        if (tail.val==val){
            Node node = head;
            while(node.next != tail){
                node = node.next;
            }
            tail = node;
            tail.next = head;
            size--;
            return;
        }

        while(temp.next.val != val){
            if (temp == head){
                System.out.println("Value not found");
                return;
            }
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    public void insert(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            size++;
            return;
        }
        node.next=head;
        tail.next = node;
        tail = node;
        size++;
    }

    public void display(){
        Node temp = head;
        if (head != null){
            do {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            } while (temp != head);
        }
        System.out.println("HEAD");
    }

    public CLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    private class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }
}
