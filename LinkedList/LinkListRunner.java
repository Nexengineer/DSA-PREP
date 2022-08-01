import java.lang.String;
public class LinkListRunner {
    private static final String dashedLine = "------------------> ";

    // public static void main (String [] args){
    //     System.out.println(dashedLine + "Linked List Runner");
    //     // basicLinkedList();
    //     replaceOccurances();
    // }

    static void replaceOccurances(){
        LinkedListNode ll = new LinkedListNode(1);
        ll.addNode(2);
        ll.addNode(3);
        ll.addNode(1);
        ll.addNode(5);
        ll.addNode(2);
        ll.addNode(7);
        System.out.println(dashedLine);
        LinkedListNode.print(ll);
        LinkedListNode.removeDuplicateInLinkedList(ll);
        System.out.println(dashedLine);
        LinkedListNode.print(ll);
    }

    static void basicLinkedList(){
        LinkedListNode ll = new LinkedListNode(1);
        ll.addNode(2);
        ll.addNode(3);
        ll.addNode(4);
        ll.addNode(5);
        ll.addNode(6);
        ll.addNode(7);
        System.out.println(dashedLine);
        LinkedListNode.print(ll);
        ll.removeNode(5);
        System.out.println(dashedLine);
        LinkedListNode.print(ll);
    }
}
