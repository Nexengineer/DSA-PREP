package Tree;

public class ConvertSortedArrayToTree {
    public Node createTree(int[] nums){
        return createTreeRecursive(nums, 0, nums.length -1);
    }

    private Node createTreeRecursive(int[] nums, int start, int end) {
        if(start>end){
            return null;
        }
        int mid = start+(end -start)/2;
        Node newNode = new Node(nums[mid]);

        newNode.leftChild = createTreeRecursive(nums, start, mid-1);
        newNode.leftChild = createTreeRecursive(nums, mid+1, end);
        return newNode;
    }
}
