/**
 * @Title: 746. Min Cost Climbing Stairs
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/25
 */
public class MinCostClimbingStairs {
    
    public int minCostClimbingStairs(int[] cost) {
        // dp[i] means the final step to the top
        // dp[i] = cost[i] + min(dp[i + 1], dp[i + 2])
        int[] dp = new int[cost.length];
        dp[cost.length - 1] = cost[cost.length - 1];
        dp[cost.length - 2] = cost[cost.length - 2];
        for (int i = cost.length - 3; i >= 0; --i) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }

}
