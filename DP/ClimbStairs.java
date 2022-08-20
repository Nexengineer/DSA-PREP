package DP;

// https://leetcode.com/problems/climbing-stairs/
public class ClimbStairs {
    public int climbStairs(int n) {
        int a[] = new int[n+1];
        a[0] = 1;
        a[1] = 1;
        int counter = 2;
        while(counter<n+1){
            a[counter] = a[counter-1] + a[counter-2];
            counter++;
        }
        
        return a[n];
    }
    
    /* Memo solution
    public int climbStairs(int n) {
        int[] mem = new int[n+1];
        Arrays.fill(mem, -1);
        return climbStairDp(n, mem);
    }
    
    int climbStairDp(int n, int [] mem){
        if(mem[n] != -1){
            return mem[n];
        }
        if(n == 1 || n == 0){
            mem[n] = 1;
            return mem[n];
        }
        int n1 = climbStairs(n-1);
        int n2 = climbStairs(n-2);
        mem[n] = n1+n2;
        return mem[n];
    }*/
}
