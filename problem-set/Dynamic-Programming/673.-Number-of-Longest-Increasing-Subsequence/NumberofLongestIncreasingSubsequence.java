import java.util.Arrays;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/29
 */
public class NumberofLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        Arrays.fill(dp, 1);
        int max = 1, res = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        max = Math.max(max, dp[i]);
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        for (int i = 0; i < count.length; ++i) {
            if (dp[i] == max) {
                res += count[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new NumberofLongestIncreasingSubsequence().findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }

}
