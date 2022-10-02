package BacktrackingRecursion;
import java.util.*;

//[Medium]: O(n2^n) https://leetcode.com/problems/subsets/
public class FindSubset {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        doDFS(nums, new ArrayList<>(), 0);
        
        return res;        
    }
    
    public void doDFS(int[] nums, List<Integer> list, int i){
        if(i >= nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        list.add(nums[i]);
        doDFS(nums, list, i+1);
        list.remove(list.size() - 1);
        doDFS(nums, list, i+1);
    }
}
