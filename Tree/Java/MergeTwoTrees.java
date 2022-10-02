package Tree;

public class MergeTwoTrees {
    public Node mergeTrees(Node root1, Node root2) {
        if(root1 == null && root2 == null){
            return null;
        }
         if(root1 == null){
             return root2;
         }
         if(root2 == null){
             return root1;
         }
         
         root1.data = root1.data + root2.data;
         root1.leftChild = mergeTrees(root1.leftChild, root2.leftChild);
         root1.rightChild = mergeTrees(root1.rightChild, root2.rightChild);
         
         return root1;
     }
}
