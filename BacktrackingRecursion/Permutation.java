package BacktrackingRecursion;
import java.util.*;

// Permutations: https://leetcode.com/problems/permutations/
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        combos(0,nums,ans);
        return ans;
    }
    
    
    void combos(int index , int[] nums , List<List<Integer>> ans){
        if(index == nums.length){
            List<Integer> dp = new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++){
                dp.add(nums[i]);
            }
            ans.add(new ArrayList<>(dp));
            return;
        }
       
        for(int i=index ; i<nums.length ; i++){
            swap(i,index,nums);
            combos(index+1 , nums , ans);
            swap(i,index,nums);
        }
    }
    
    void swap(int i , int j , int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } 
}
