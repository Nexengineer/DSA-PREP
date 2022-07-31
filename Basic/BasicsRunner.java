import java.lang.String;

import Strings.IsUnique;
import Strings.Permutation;

public class BasicsRunner {
    private static final String dashedLine = "------------------> ";
    
    // public static void main(String [] args) {
    //     System.out.println("This is the basic runner class");
    //     // checkUnique(); //<--------- check uniqueness of the string
    //     // checkPermutation(); //<-------- check if string is permutation of other string
    // } 

    public static void checkUnique(){
        System.out.println(dashedLine + "Brute Force -> O(n^2)");
        System.out.println(IsUnique.checkBruteForce("soome"));
        System.out.println(IsUnique.checkBruteForce("some"));

        System.out.println(dashedLine + "Optimized Approach -> O(n)");
        System.out.println(IsUnique.check("some"));
        System.out.println(IsUnique.check("somee"));
    }

    public static void checkPermutation(){
        System.out.println(dashedLine + "Optimized Approach -> O(n)");
        System.out.println(Permutation.checkForPermutation("sum", "mus"));
        System.out.println(Permutation.checkForPermutation("mom", "mmom"));
    }
}
