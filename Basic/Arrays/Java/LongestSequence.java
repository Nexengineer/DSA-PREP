package Arrays;
import java.util.*;
// [Medium]:  https://leetcode.com/problems/longest-consecutive-sequence/submissions/
public class LongestSequence {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            q.add(Integer.valueOf(nums[i]));
        }
        
        int previous = q.poll();
        int current;
        int maxLength = 0;
        int currentLength = 0;
        
        while(!q.isEmpty()){
            current = q.poll();
            if(previous == current){
                previous = current;
                continue;
            }
            if(Math.abs(current-previous) == 1){
                currentLength++;
            } else {
                maxLength = Math.max(currentLength, maxLength);
                currentLength = 0;
            }
            
            previous = current;
        }
        
        return maxLength+1;
    }
}
