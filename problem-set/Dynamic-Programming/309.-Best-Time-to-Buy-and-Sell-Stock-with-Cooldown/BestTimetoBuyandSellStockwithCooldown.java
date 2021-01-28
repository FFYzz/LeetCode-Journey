/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/1/29
 * @Description:
 */
public class BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // 定义三个状态

        // 持有股票时的利润，持有第一只股票时利润为负数
        // 前置操作: 1. 未持有 -> 持有 或者 2. 已经持有
        // 下一步操作只能为继续持有或者卖出
        int[] state1 = new int[prices.length];
        // 卖出股票时持有的利润
        // 前置操作: 1. 只能为卖出股票
        // 下一步操作只能为 cooldown
        int[] state2 = new int[prices.length];
        // cooldown 时的股票利润
        // 前置操作: 1. 上一个时间周期也是 cooldown 2. 上个周期刚卖出
        // 下一步操作为继续 cooldown 或者买入股票
        int[] state3 = new int[prices.length];
        state1[0] = -prices[0];
        // 不存在这种情况
        state2[0] = Integer.MIN_VALUE;
        state3[0] = 0;
        for (int i = 1; i < prices.length; ++i) {
            // state1[i - 1] 持有上一只股票
            // state3[i - 1] - prices[i] 持有股票
            state1[i] = Math.max(state1[i - 1], state3[i - 1] - prices[i]);
            // 在当前时机卖出股票
            state2[i] = prices[i] + state1[i - 1];
            // 在当前时机处于 cooldown 状态
            state3[i] = Math.max(state2[i - 1], state3[i - 1]);
        }
        return Math.max(Math.max(state1[prices.length - 1], state2[prices.length - 1]), state3[prices.length - 1]);
    }

}
