package Search;

import java.util.List;

public class BinarySearch {
    public static Integer doBinarySearch(List<Integer> input, int valueToFind, int start, int end){
        if(start>end){
            System.out.println("Value Not Found");
            return -1;
        } else {
            int mid = (start + end)/2;
            if (input.get(mid) == valueToFind){
                System.out.println("Value found at index: " + mid);
                return 0;
            }
    
            if(input.get(mid)<valueToFind)
                return doBinarySearch(input, valueToFind, mid+1, end);
            else
                return doBinarySearch(input, valueToFind, start, mid-1);
        }
    }
}
