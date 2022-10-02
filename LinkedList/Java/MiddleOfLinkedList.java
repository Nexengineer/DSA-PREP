package Problems;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        if(head.next == null){
            return  head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
