/**
 * @Title: 1155. Number of Dice Rolls With Target Sum
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/7/15
 */
public class NumberofDiceRollsWithTargetSum {

    public int numRollsToTarget(int d, int f, int target) {
        int mod = 1000000007;
        if (d * f < target) {
            return 0;
        }
        //dp[i][j]，使用 i 个 dice 摇出 j 的可能性
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= d; ++i) {
            for (int j = 0; j <= target; ++j) {
                for (int k = 1; k <= f; ++k) {
                    if (j - k >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                    }
                }
            }
        }
        return dp[d][target];
    }

}
