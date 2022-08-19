package Arrays;

//[Medium]: Container With Most Water => https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length -1;
        int maxVolume = 0;
        
        while(start<end){
            int current = 0;
            if(height[start]<height[end]){
                current = height[start]*(end-start);
                start++;
            } else {
                current = height[end]*(end-start);
                end--;
            }
            System.out.println(current);
            maxVolume = Math.max(current, maxVolume);
        }
        
        return maxVolume;
    }
}
