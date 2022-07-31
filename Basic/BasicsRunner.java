import java.lang.String;

import Strings.IsUnique;

public class BasicsRunner {
    public static void main(String [] args) {
        System.out.println("This is the basic runner class");
        checkUnique(); //<--------- check uniqueness of the string
    } 

    public static void checkUnique(){
        System.out.println("------------------> Brute Force");
        System.out.println(IsUnique.checkBruteForce("soome"));
        System.out.println(IsUnique.checkBruteForce("some"));

        System.out.println("------------------> Optimized Approach");
        System.out.println(IsUnique.check("some"));
        System.out.println(IsUnique.check("somee"));
    }
}
