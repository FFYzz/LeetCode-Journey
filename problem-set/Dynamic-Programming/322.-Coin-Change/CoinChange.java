/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/2
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            dp[i] = amount + 1;
        }
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (coins[j] > i) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
