import java.util.ArrayList;
import java.util.List;

import Search.BinarySearch;

public class DsaPrepRunner {
    private static final String dashedLine = "------------------> ";
    public static void main(String [] args){
        System.out.println(dashedLine + "DSA-Runner");
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(3);
        input.add(5);
        input.add(7);
        input.add(9);
        input.add(11);
        BinarySearch.doBinarySearch(input, 5, 0, input.size()-1);
        BinarySearch.doBinarySearch(input, 15, 0, input.size()-1);
    }
}
