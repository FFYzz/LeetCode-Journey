/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/1/22
 * @Description:
 */
public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        int length = nums.length, res = 0;
        int[][] dp = new int[length + 1][length + 1];
        for (int i = 1; i <= length; ++i) {
            dp[i][i] = nums[i - 1];
        }
        for (int i = 1; i <= length; ++i) {
            for (int j = i; j <= length; ++j) {
                if (i != j) {
                    dp[i][j] = dp[i][j - 1] * nums[j - 1];
                }
                if (dp[i][j] < k) {
                    ++res;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, i, j, product = 1;
        for (i = 0, j = 0; j < nums.length; ++j) {
            product *= nums[j];
            while (i <= j && product >= k) {
                product /= nums[i];
                ++i;
            }
            // 新增的子数组数
            res += (j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        new SubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
    }

}
