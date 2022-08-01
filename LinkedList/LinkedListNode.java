import java.util.HashSet;
import java.util.Set;

// This the basic linked list representation
public class LinkedListNode {
    private LinkedListNode next;
    private int data;

    LinkedListNode(int data){
        this.data = data;
        this.next = null;
    }

    public void addNode(int data){
        LinkedListNode newNode =  new LinkedListNode(data);
        LinkedListNode head = this;

        while (head.next != null){
            head = head.next;
        }
        head.next = newNode;
    }

    public void removeNode(int data){
        LinkedListNode node = this;
        if (node.data == data){
            node = node.next;
            return;
        }
        while (node.next != null){
            if (node.next.data == data){
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }

    public static void print(LinkedListNode head){
        LinkedListNode node = head;
        System.out.print(node.data + "->");
        while(node.next != null){
            node = node.next;
            System.out.print(node.data + "->");
        }
        System.out.println();
    }

    // [Easy] Stmt: Find the duplicate values in unsorted Linked List 
    public static void removeDuplicateInLinkedList(LinkedListNode linkedList) {
        Set<Integer>track = new HashSet<>();

        LinkedListNode head = linkedList;
        LinkedListNode previous  = null;
        while(head.next != null){
            if (track.contains(head.data)){
                previous.next = head.next;
            } else {
                track.add(head.data);
                previous = head;
            }
            head = head.next;
        }
    }

    
}
