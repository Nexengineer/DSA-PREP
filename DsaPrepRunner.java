import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Arrays.BuySellStocks;
import Arrays.ConsecutiveOnes;
import Problems.ListNode;
import Problems.ReverseLinkedList;
import Search.BinarySearch;
import Strings.Haystackneedle;
import Tree.BinarySearchTree;

public class DsaPrepRunner {
    private static final String dashedLine = "------------------> ";
    public static void main(String [] args){
        System.out.println(dashedLine + "DSA-Runner");
        // Code to run
            // runBinarySearchProblem();
            // runBSTImplementation();
            // bestTimeToBuyStocks();
            // runConcecutiveOnes();
            // runMergeIntervals();
            // runReverseLinkedList();
            // runInsertionSort();
            // runQuickSort();
            // runHayStackNeedle();
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
        // --------> One child on the left 
        // tree.deleteNode(tree.root, 2);
        // --------> One child on the right 
        // tree.deleteNode(tree.root, 18);
        // --------> With root node deleted (both childrens)
        // tree.deleteNode(tree.root, 10);
        System.out.println(dashedLine + "InOrder");
        tree.doInorderTraversal(tree.root);
        System.out.println(dashedLine + "PreOrder");
        tree.doPreOrderTraversal(tree.root);
        System.out.println(dashedLine + "PostOrder");
        tree.doPostOrderTraversal(tree.root);
        System.out.println(dashedLine + "Level Order");
        tree.doBreathFirstTraversal(tree.root);
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

    public static void bestTimeToBuyStocks(){
        int a[] = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(BuySellStocks.findMaxProfit(a, 6));
    }

    public static void runConcecutiveOnes(){
        int a[] = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        ConsecutiveOnes.countConsicutiveOnes(a, 2);
    }

    public static void runMergeIntervals(){
        // new int [] {[1,3], [2,6], [8,10]}
        // MergeIntervals.compute();;
    }

    public static void runReverseLinkedList(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode.print(node1);
        ListNode newNode = ReverseLinkedList.reverseLinkedListRecursive(node1);
        ListNode.print(newNode);
    }

    public static void runInsertionSort(){
        int a[] = new int[]{4, 5, 10, 43, 57, 91, 45, 9, 7};
        InsertionSort.sort(a);
    }

    public static void runQuickSort(){
        int a[] = new int[]{4, 5, 10, 43, 57, 91, 45, 9, 7};
        QuickSort method = new QuickSort();
        method.sort(a, 0, a.length-1);
        InsertionSort.printArray(a);
    }

    public static void runHayStackNeedle(){
        System.out.println(Haystackneedle.strStr("hello", "ll"));
    }
}
