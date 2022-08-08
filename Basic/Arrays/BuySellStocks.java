package Arrays;

// [Easy]: We just have to maintain two variables
public class BuySellStocks {
    public static int findMaxProfit(int[] a, int n){
        if(n <= 0){
            return 0;
        }
        int minimumValue = a[0];
        int maxProfit = 0;
        for(int i=0; i<n; i++){
            minimumValue = Math.min(a[i], minimumValue);
            maxProfit = Math.max(a[i]-minimumValue, maxProfit);
        }

        return maxProfit;
    }
}
