package Problems;

// [Easy]
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

    // Approach 2: Recursive approach
    public static ListNode reverseLinkedListRecursive(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode rest = reverseLinkedListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }


}
