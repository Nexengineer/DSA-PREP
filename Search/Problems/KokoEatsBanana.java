package Search.Problems;

// https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatsBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        for(int i =0; i< piles.length; i++){
            if(end < piles[i]){
                end = piles[i];
            }
        }
                
        while(start < end){
            int mid = (start+end)/2;
            int totalNumberOfHours = 0;
            for(int i =0 ; i<piles.length; i++){
                totalNumberOfHours += (int)Math.ceil((double)piles[i]/mid);
            }
            
            if (totalNumberOfHours <= h) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
