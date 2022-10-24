import java.util.*;

class Solution {

    public void backtrack(int[] candidates, int target, int i, List<List<Integer>> list, List<Integer> arr) {
        if (i == candidates.length) {
            if (target == 0) {
                list.add(new ArrayList<>(arr));
            }
            return;
        }

        if (target >= candidates[i]) {
            arr.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, list, arr);
            arr.remove(arr.size() - 1);
        }
        backtrack(candidates, target, i + 1, list, arr);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(candidates, target, 0, list, new ArrayList<>());
        return list;
    }
}