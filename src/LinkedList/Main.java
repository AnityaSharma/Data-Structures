package LinkedList;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(88);
        list.insertFirst(4);
        list.insertFirst(1);
        list.insertFirst(54);
        list.insertFirst(34);
        list.insertLast(55);
//        list.insert(101,3);
//        list.display();
//        System.out.println(list.delete(3));
//        list.display();
//        System.out.println();
//        DLL list = new DLL();
//        list.insertFirst(88);
//        list.insertFirst(4);
//        list.insertFirst(1);
//        list.insertFirst(54);
//        list.insertFirst(34);
//        list.insertLast(60);
//
//        list.insert(69,2);
//        list.display();
//        list.displayRev();

//        CLL list = new CLL();
//        list.insert(3);
//        list.insert(56);
//        list.insert(86);
//        list.insert(7);
//        list.insert(45);
//        list.insert(33);
        list.display();
        list.insertRec(101,0);
        list.display();

    }
}
