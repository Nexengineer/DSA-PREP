import java.util.ArrayList;
import java.util.List;

import Search.BinarySearch;
import Tree.BinarySearchTree;

public class DsaPrepRunner {
    private static final String dashedLine = "------------------> ";
    public static void main(String [] args){
        System.out.println(dashedLine + "DSA-Runner");
        System.out.println(dashedLine);
        // Code to run
            // runBinarySearchProblem();
            runBSTImplementation();

        System.out.println(dashedLine);
    }

    public static void runBSTImplementation(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(6);
        tree.add(11);
        tree.add(16);
        tree.add(2);
        tree.add(4);

        tree.doInorderTraversal(tree.root);
    }

    public static void runBinarySearchProblem(){
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
