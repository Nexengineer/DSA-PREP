> https://leetcode.com/problems/same-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        
        if (p == null && q != null || q == null && p != null) {
            return false;
        }
        
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        TreeNode currentP = p;
        TreeNode currentQ = q;
        
        while((currentP != null && currentQ != null) || (!stackP.isEmpty() && !stackQ.isEmpty())){
            while(currentP != null && currentQ != null) {
                stackP.push(currentP);
                stackQ.push(currentQ);
                currentP = currentP.left;
                currentQ = currentQ.left;
                if ((currentP == null && currentQ != null) || (currentQ == null && currentP != null)){
                    return false;
                }
            }
            currentP = stackP.pop();
            currentQ = stackQ.pop();
            if (currentP.val != currentQ.val) {
                return false;
            }
            currentP = currentP.right;
            currentQ = currentQ.right;
            if ((currentP == null && currentQ != null) || (currentQ == null && currentP != null)){
                    return false;
            }
        }
        return true;
    }
    }


