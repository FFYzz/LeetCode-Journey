/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/1/3
 */
public class HouseRobber {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            dp[i] = Math.max(nums[i - 1] + (i - 2 >= 0 ? dp[i - 2] : dp[0]), dp[i - 1]);
        }
        return dp[nums.length];
    }

}
