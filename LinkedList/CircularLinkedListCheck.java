// This the structure of Linked list node 
class Node {
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

// This class for checking the whether linked list is circlular or not 
// This method method will use FLOYED NUMBER THEORY
class CircularLinkedListCheck {
    public static void main(String[] args){
        // Configuring a circular linked list 
        var root = new Node(00);
        Node node1 = new Node(10);
        root.next = node1;
        Node node2 = new Node(20);
        node1.next = node2;
        Node node3 = new Node(30);
        node2.next = node3;
        Node node4 = new Node(40);
        node3.next = node4;
        Node node5 = new Node(50);
        node4.next = node5;
        Node node6 = new Node(60);
        node5.next = node6;
        node6.next = node3;
        isCircular(root);
    }

    public static void isCircular(Node head){
        // Covering the default case 
        if (head == null || head.next == null){
            System.out.println("This is not a circular linked list");
        }

        //creating pointers 
        Node fastPtr = head;
        Node slowPtr = head;
        Boolean isCircle = false;
        while(fastPtr != null || fastPtr.next != null){ 
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next; 
            if (fastPtr == slowPtr){
                isCircle = true;
                break;
            }
        }
        System.out.println(isCircle ? "This is a circular linked list" : "This is not a circular linked list");

        // Find the origin of loop
        slowPtr = head;
        while(slowPtr != fastPtr){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        System.out.println(slowPtr.data);
    }

}