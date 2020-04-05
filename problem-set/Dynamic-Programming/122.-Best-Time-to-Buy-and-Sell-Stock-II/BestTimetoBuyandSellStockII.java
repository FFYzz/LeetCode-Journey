/**
 * @Title: 122. Best Time to Buy and Sell Stock II
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/5
 */
public class BestTimetoBuyandSellStockII {

    /**
     * Greedy
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            res += prices[i + 1] > prices[i] ? (prices[i + 1] - prices[i]) : 0;
        }
        return res;
    }

}
