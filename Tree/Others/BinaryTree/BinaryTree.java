import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    Integer data;
    TreeNode leftNode;
    TreeNode rightNode;

    TreeNode(Integer data){
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public static void preorderDFS(TreeNode root){
        if(root != null){
            System.out.println(root.data);
            preorderDFS(root.leftNode);
            preorderDFS(root.rightNode);
        }
    }
    public static void inorderDFS(TreeNode root){
        if(root != null){
            inorderDFS(root.leftNode);
            System.out.println(root.data);
            inorderDFS(root.rightNode);
        }
    }
    public static void postOrderDFS(TreeNode root){
        if(root != null){
            postOrderDFS(root.leftNode);
            postOrderDFS(root.rightNode);
            System.out.println(root.data);
        }
    }
    public static void levelOrderTraversal(TreeNode root){
        if(root == null){
            System.out.println("This tree is empty");
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curTreeNode;    
        while(!queue.isEmpty()){
            curTreeNode = queue.remove();
            System.out.println(curTreeNode.data);
            if(curTreeNode.leftNode != null){
                queue.add(curTreeNode.leftNode);
            }
            if(curTreeNode.rightNode != null){
                queue.add(curTreeNode.rightNode);
            }
        }
    }
    public static int heightOfTree(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = heightOfTree(root.leftNode);
        int rightHeight = heightOfTree(root.rightNode);

        if(leftHeight > rightHeight){
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }
}
/*
        (4)
     (5)   (8)
   (6)(7) (9)(10)
*/
class BinaryTree {
    // public static void main(String[] args){
    //     TreeNode root = new TreeNode(4);
    //     TreeNode node1 = new TreeNode(5);
    //     TreeNode node2 = new TreeNode(8);
    //     root.leftNode = node1;
    //     root.rightNode = node2;
    //     TreeNode node3 = new TreeNode(6);
    //     TreeNode node4 = new TreeNode(7);
    //     node1.leftNode = node3;
    //     node1.rightNode = node4;
    //     TreeNode node5 = new TreeNode(9);
    //     TreeNode node6 = new TreeNode(10);                                                      
    //     node2.leftNode = node5;
    //     node2.rightNode = node6;
    //     TreeNode node7 = new TreeNode(11);
    //     TreeNode node8 = new TreeNode(12);
    //     node3.leftNode = node7;
    //     node3.rightNode = node8;
    //     TreeNode node9 = new TreeNode(13);
    //     node4.leftNode = node9;
    //     // Traversal
    //     // TreeNode.preorderDFS(root);
    //     // System.out.println("---------------------------------------->");
    //     // TreeNode.inorderDFS(root);
    //     // System.out.println("---------------------------------------->");
    //     // TreeNode.postOrderDFS(root);
    //     // System.out.println("---------------------------------------->");
    //     // TreeNode.levelOrderTraversal(root);
    //     System.out.println(TreeNode.heightOfTree(root));
    // }
}

