package Basic.Arrays;

//[Medium]: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BuySellStocksII {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int profit = 0;
        int maxProfit = 0;
        while(r<prices.length){
            profit = prices[r] - prices[l];
            l = r;
            maxProfit = Math.max(maxProfit, maxProfit+profit);
            profit = 0;
            r++;
        }
        
        return maxProfit;
    }
}
