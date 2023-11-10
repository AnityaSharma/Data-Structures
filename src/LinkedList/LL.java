package LinkedList;

public class LL {
    private class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value=value;
            this.next=next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size = 0;
    }

    public void insertRec(int val,int index){
        Node temp = head;
        if(index==0){
           Node node = new Node(val);
           node.next = head;
           head = node;
           return;
        }
        helper(index,temp,val);
    }
    private Node helper(int index,Node temp,int val){
//        if (temp == null){
//            System.out.println("index not valid");
//            return;
//        }
        if (index==0){
            Node node = new Node(val);
            node.next = temp;
            size++;
            return node;
        }
        temp.next = helper(index-1,temp.next,val);
        return temp;
    }
    public int deleteLast(){
        if ( head == tail){
            return deleteFirst();
        }
        Node node = get(size-2);
        int  val = tail.value;
        tail = node;
        node.next = null;
        size--;
        return val;
    }

    public Node find(int value){
        Node node = head;
        while(node != null) {
            if (node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public int delete(int index){
        if (index == 0){
            return deleteFirst();
        }
        if (index == size-1){
            return deleteLast();
        }
        Node node = get(index);
        int val = node.next.value;
        node.next = node.next.next;
        return val;
    }
    public Node get(int index){
        Node node = head;
        for (int i = 1; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if (head== null){
            tail = null;
        }
        size--;
        return val;
    }

    public void insert(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if (index == size){
            insertLast(val);
            return;
        }
        Node nTemp = head;
        for (int i = 1; i < index; i++) {
            nTemp=nTemp.next;
        }
        Node node = new Node(val,nTemp.next);
        nTemp.next = node;
        size++;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail==null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int val){
        if (tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;

        size++;
    }
    public void display(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.value + " -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }
}
