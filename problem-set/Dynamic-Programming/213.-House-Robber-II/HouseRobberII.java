import java.util.Arrays;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/1/3
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob1(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                rob1(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int rob1(int[] nums) {
        int[] dp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            dp[i] = Math.max(nums[i - 1] + (i - 2 >= 0 ? dp[i - 2] : dp[0]), dp[i - 1]);
        }
        return dp[nums.length];
    }

}
