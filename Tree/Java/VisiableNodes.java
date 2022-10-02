package Tree;
//[Medium]: Count Good Nodes in Binary Tree: A preorder traversal of the tree is enough
public class VisiableNodes {
    private int counter = 0;
    private int max = 0;
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        if(root.val >= max){
            max = root.val;
            counter ++;
        }
        
        goodNodes(root.left);
        goodNodes(root.right);
        
        return counter;
    }
}
