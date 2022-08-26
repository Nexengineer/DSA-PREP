package Basic.Arrays;

//[ Boyers meyer voting algorithm] https://leetcode.com/problems/majority-element/solution/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int value = nums[0];
        
        for(int i = 1; i<nums.length; i++){
            if(count<0){
                count = 0;
                value = nums[i];
            } else if(value == nums[i]){
                count ++;
            } else {
                count --;
            }
        }
        
        return value;
    }
}
