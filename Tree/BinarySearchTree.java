package Tree;

// Property of binay tree is 
//  1) all the smaller element crossponding to root is on the left.
//  2) all the bigger element crossponding to root is on the right.
public class BinarySearchTree {
    public Node root;
    
    public void add(Integer data){
        Node newNode = new Node(data);
        insertNode(newNode, root);
    }

    public void doInorderTraversal(Node node){
        if(node == null){
            return;
        }
        doInorderTraversal(node.leftChild);
        System.out.println(node.data);
        doInorderTraversal(node.rightChild);
    }

    private void insertNode(Node newNode, Node node){
        if (node == null){
            node = newNode;
        }
        if(node.data < newNode.data){
            insertNode(newNode, node.rightChild);
        }
        if (node.data > newNode.data){
            insertNode(newNode, node.leftChild);
        }
    }

}
