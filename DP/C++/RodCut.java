//Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if the length of the rod is 8 and the values of different pieces are given as the following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6) 
// A Dynamic Programming solution for Rod cutting problem
class RodCutting
{
    static int cutRod(int price[],int n)
    {
        int val[] = new int[n+1];
        val[0] = 0;
 
        // make the table val[] in bottom up manner and return the last entry from the table
        for (int i = 1; i<=n; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val,
                                   price[j] + val[i-j-1]);
            val[i] = max_val;
        }
 
        return val[n];
    }
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int a[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = a.length;
        System.out.println("Maximum Obtainable Value is " +
                            cutRod(a, size));
    }
}
