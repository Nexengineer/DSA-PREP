package Basic.Arrays;
import java.util.*;

// https://leetcode.com/problems/pascals-triangle/submissions/
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> subOut = new ArrayList<>();
            List<Integer> prevList = new ArrayList<>();
            if (i != 1) {
                prevList = output.get(i - 2);
            }
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    subOut.add(1);
                } else {
                    subOut.add(prevList.get(j - 1) + prevList.get(j));
                }
            }
            output.add(subOut);
        }
        return output;
    }
}
