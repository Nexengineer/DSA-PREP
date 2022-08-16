package Tree;
import java.util.*;
public class RangeSumTree {
    public void inOrder(Node root, List<Integer> sort){
        if(root != null){
            inOrder(root.leftChild, sort);
            sort.add(root.data);
            inOrder(root.rightChild, sort);
        }
    }

    public int rangeSumBST(Node root, int low, int high) {
        if (root == null){
            return 0;
        }
        List<Integer> sorted = new ArrayList<>();
        inOrder(root, sorted);
        
        boolean flag = false;
        int sum = 0;
        for(Integer i : sorted){
            if(i == low){
                flag = true;
            }
            if(flag){
                sum += i;
            }
            
            if(i == high){
                flag = false;
                break;
            }
        }
        return sum;
    
    }
}
