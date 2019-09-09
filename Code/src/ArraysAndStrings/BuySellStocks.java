package ArraysAndStrings;

public class BuySellStocks {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0 || n == 1)
            return 0;
        int minPos = prices[0], prevProfit = 0, profit = 0;
        for (int i = 1; i < n; i++) {
            if (i != n - 1 && prices[i] < minPos) {
                minPos = prices[i];
                if (profit > prevProfit)
                    prevProfit = profit;
                profit = 0;
            }
            int temp = prices[i] - minPos;
            if (temp > profit) {
                profit = temp;
            }
        }
        return profit > prevProfit ? profit : prevProfit;
    }
}
