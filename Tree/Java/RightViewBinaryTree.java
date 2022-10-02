package Tree;
import java.util.*;

//[Medium]: Given the root of a binary tree, imagine yourself standing on the right side of it,
//  return the values of the nodes you can see ordered from top to bottom.
public class RightViewBinaryTree {
    public void view(TreeNode root, List<Integer> views, int level){
        if(root == null){
            return;
        }
        
        if(views.size() < level){
            views.add(root.val);
        }
        view(root.right, views, level+1);
        view(root.left, views, level+1); 
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        view(root, list, 1);
        return list;
    }
}
