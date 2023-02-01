package BacktrackingRecursion.Java;
import java.util.*;

public class FindSubsetII {
    private List<List<Integer>> response = new ArrayList<>();
    
    public void getSubsetii(int[] nums){
        doDFS(nums, 0, new ArrayList<Integer>());
    }

    private void doDFS(int[] nums, int i, List<Integer> arrayList) {
        if(i >= nums.length){
            response.add(new ArrayList<>(arrayList));
            return;
        }

        arrayList.add(nums[i]);
        doDFS(nums, i+1, arrayList);
        arrayList.remove(arrayList.size()-1);
        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        doDFS(nums, i+1, arrayList);
    }
}
