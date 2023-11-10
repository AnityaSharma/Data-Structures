package LinkedList.Leetcode;
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
public class LinkedListCycle142 {
    public static void main(String[] args) {


    }

    static ListNode solution(ListNode head){
//        ListNode head = new ListNode(3);
        ListNode fast = head;
        ListNode slow = head;

        while( fast != null && fast.next != null){
            if (fast == slow){
                return cyclicLength(head, fast, slow);
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return null;

    }
    static ListNode cyclicLength(ListNode head,ListNode fast,ListNode slow){
        int length = 0;
        do {
            slow = slow.next;
            length++;
        }while(slow != fast);

        ListNode f = head;
        ListNode s = head;

        while(length >0){
            f = f.next;
            length--;
        }

        while(f != s){
            f = f.next;
            s = s.next;
        }

        return f;
    }
    
}

