package Tree;

// Property of binay tree is 
//  1) all the smaller element crossponding to root is on the left.
//  2) all the bigger element crossponding to root is on the right.
public class BinarySearchTree {
    public Node root;
    
    public void add(Integer data){
        if (this.root == null){
            this.root = new Node(data);
            return;
        }
        insertNode(this.root, data);
    }

    public void doInorderTraversal(Node node){
        if(node != null){
            doInorderTraversal(node.leftChild);
            System.out.println(node.data + ",");
            doInorderTraversal(node.rightChild);
        }
    }

    private Node insertNode(Node node, Integer data){
        if (node == null){
            return new Node(data);
        }

        if (node.data > data){
            node.leftChild = insertNode(node.leftChild, data);
        }

        if(node.data < data){
            node.rightChild = insertNode(node.rightChild, data);
        }
        
        return node;
    }

}
