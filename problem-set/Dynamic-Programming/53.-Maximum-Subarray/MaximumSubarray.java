/**
 * @Title: 53. Maximum Subarray
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/26
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        // dp[i]: the maxSubArray between [0,i] that must contains nums[i]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }

}
