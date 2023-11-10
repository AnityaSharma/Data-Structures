//package LinkedList.Leetcode;
//
//import LinkedList.LL;
//
//import java.util.LinkedList;
//
//public class SortList148 {
//    private LinkedList.Leetcode.ListNode head;
//    public void insertFirst(int val){
//        LinkedList.Leetcode.ListNode node = new LinkedList.Leetcode.ListNode(val);
//        node.next = head;
//        head = node;
//    }
//
//    public static void main(String[] args) {
//
//
//    }
//
//    public LinkedList.Leetcode.ListNode sortList(LinkedList.Leetcode.ListNode head) {
//        if (head == null) {
//            return head;
//        }
//        if (head.next == null) {
//            return head;
//        }
//        int size = size(head);
//
//        sortList(head, size - 1, 0);
//
//        return head;
//    }
//
//    private void sortList(LinkedList.Leetcode.ListNode head, int row, int col) {
//        if (row == 0){
//            return;
//        }
//        if (col < row) {
//            LinkedList.Leetcode.ListNode f = get(col,head);
//            LinkedList.Leetcode.ListNode s = get(col+1,head);
//            if (f.val>s.val){
//                if (f==head){
//                    head = s;
//                    f.next = s.next;
//                    head.next=f;
//                }else if(s.next == null){
//                    LinkedList.Leetcode.ListNode prev = get(col-1,head);
//                    prev.next = s;
//                    s.next = f;
//                    f.next = null;
//                }else {
//                    LinkedList.Leetcode.ListNode prev = get(col-1,head);
//                    f.next = s.next;
//                    prev.next = s;
//                    s.next = f;
//                }
//            }
//            sortList(head,row,col+1);
//        } else {
//            sortList(head, row - 1, 0);
//        }
//    }
//
//
//    static LinkedList.Leetcode.ListNode get(int i, LinkedList.Leetcode.ListNode head) {
//        int t = 0;
//        LinkedList.Leetcode.ListNode temp = head;
//        do {
//            temp = temp.next;
//            t++;
//        } while (t < i);
//        return temp;
//    }
//
//    static int size(LinkedList.Leetcode.ListNode head) {
//        LinkedList.Leetcode.ListNode temp = head;
//        int length = 0;
//        while (temp != null) {
//            temp = temp.next;
//            length++;
//        }
//        return length;
//    }
//
//    private class ListNode {
//        private int value;
//        private ListNode next;
//        public ListNode(int value){
//            this.value = value;
//        }
//
//        public ListNode(int value, ListNode next){
//            this.value=value;
//            this.next=next;
//        }
//    }
//}
