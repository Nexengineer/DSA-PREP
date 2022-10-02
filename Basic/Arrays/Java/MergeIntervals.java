package Arrays;
import java.util.*;

// [Medium] https://leetcode.com/problems/merge-intervals/submissions/
//  1) Check with interviewer if it is sorted
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        List<int []> response = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++) {
            if(i == 0) {
                response.add(intervals[i]);
            } else {
                int[] prev = response.get(response.size()-1);
                int[] curr = intervals[i];
                if(curr[0] <= prev[1]) {
                    prev[1] = Math.max(curr[1], prev[1]);
                }else {
                    response.add(curr);
                }
            }
        }
        
        return response.toArray(new int[response.size()][2]);
    }
}
