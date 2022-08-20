package Greedy;

// Medium: Jump Game => https://leetcode.com/problems/jump-game/submissions/
public class JumpPostions {
    public boolean canJump(int[] nums) {
        int position = nums.length -1;
        
        for(int i = nums.length - 2; i>=0 ;i--){
            if(position <= i + nums[i]){
                position = i;
            }
        }
        return position == 0 ? true : false;
    }
}
