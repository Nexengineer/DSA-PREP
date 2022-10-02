public class QuickSort {
    public QuickSort(){};
    public void sort(int[] a, int left, int right){
        if(left>=right){
            return;
        }
        int pivot = a[(left+right)/2];
        int index = partition(a, left, right, pivot);

        sort(a, left, index-1);
        sort(a, index, right);

    }

    public int partition(int[] a, int left, int right, int pivot){
        while(left <= right){
            while(a[left]<pivot){
                left++;
            }
            while(a[right]>pivot){
                right--;
            }

            if(left<=right){
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }

        return left;
    }
}
