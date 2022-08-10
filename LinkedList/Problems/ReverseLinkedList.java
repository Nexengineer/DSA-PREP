package Problems;

// [Easy]

class ListNode {
    Integer value;
    ListNode next;
}

public class ReverseLinkedList {
    // Approach one - Iterative approach
    public static ListNode reverseLinkedList(ListNode head){
        if (head == null){
            return null;
        }

        ListNode current = head;
        ListNode prev = null;

        while(current != null){
            ListNode forward = current.next;
            current.next = prev;
            prev = current;
            current = forward;
        }
        return prev;
    }
}
