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

    public Node deleteNode(Node node, int data){
        if(node == null){
            return node;
        }
        if(node.data > data) {
            node.leftChild = deleteNode(node.leftChild, data);
        } else if(node.data < data){
            node.rightChild = deleteNode(node.rightChild, data);
        } else {
            // Case 1: No children
            if (node.leftChild == null && node.rightChild == null){
                return null;
            }
            // Case 2: With one children
            if(node.rightChild == null || node.leftChild == null){
                Node copy = node.rightChild == null
                            ? node.leftChild : node.rightChild;
                return copy; 
            }
            // Case 3: With two children
            if(node.leftChild != null && node.rightChild != null){
                Node copy = node.rightChild;
                while(copy.leftChild != null){
                    copy = copy.leftChild;
                }
                node.data = copy.data;
                node.rightChild = deleteNode(node.rightChild, copy.data);
                return node;
            }
            
        }
        return node;
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
