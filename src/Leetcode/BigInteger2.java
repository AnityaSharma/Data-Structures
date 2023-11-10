//package Leetcode;
//
//import java.math.BigInteger;
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
//public class BigInteger2 {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode rl1=reverseLL(l1);
//        ListNode rl2=reverseLL(l2);
//
//        BigInteger sumRL1=concatLL(rl1);
//        BigInteger sumRL2=concatLL(rl2);
//        BigInteger ans=sumRL1.add(sumRL2);
//
//        return reverseLL(convertIntoLL(ans));
//    }
//    private ListNode convertIntoLL(BigInteger num){
//        ListNode head=new ListNode(0,null);
//        if(num.intValue()==0)return head;
//        while(num.l>0){
//            ListNode prev=new ListNode(0,head);
//            int mod=(int)(num%10);
//            num/=10;
//            head.val=mod;
//            head=prev;
//        }
//        return head.next;
//    }
//
//    private BigInteger concatLL(ListNode head){
//        if(head==null)return new BigInteger(0);
//        if(head.next==null)return new BigInteger(head.val);
//
//        String string=new String("");
//        ListNode current=head;
//        while(hasNext(current)){
//            string+=current.val;
//            current=current.next;
//        }
//        string+=current.val;
//        BigInteger num=new BigInteger(string);
//        return num;
//    }
//
//    private boolean hasNext(ListNode head){
//        return head.next!=null;
//    }
//    private ListNode reverseLL(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode prev = null;
//        ListNode current = head;
//
//        while (current != null) {
//            ListNode next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//        }
//
//        return prev;
//    }
//}
