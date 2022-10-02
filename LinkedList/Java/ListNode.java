package Problems;

public class ListNode {
    public Integer value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public static void print(ListNode head){
        ListNode node = head;
        while(node != null){
            System.out.println(node.value);
            node = node.next;
        }
    }
}
