import java.util.Arrays;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/23
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = -1;
        for (int i = 1; i < nums.length; ++i) {
            // 与前面的每一个位置比较
            for (int j = 0; j <= i - 1; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        new LongestIncreasingSubsequence().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9});
    }

}
