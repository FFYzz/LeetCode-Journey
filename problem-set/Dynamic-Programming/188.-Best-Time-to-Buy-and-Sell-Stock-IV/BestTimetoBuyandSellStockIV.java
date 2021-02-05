/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/2/5
 * @Description:
 */
public class BestTimetoBuyandSellStockIV {

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][]dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; ++i) {
            int max = -prices[0];
            for (int j = 1; j < prices.length; ++j) {
                // 当前继续持有 或者 卖出
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + max);
                // 当前买入
                max = Math.max(max, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }

}
