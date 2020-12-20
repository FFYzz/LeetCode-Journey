/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/20
 */
public class MaximumProductSubarray {

    /**
     * 穷举
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int product = 1;
            for (int j = i; j < nums.length; ++j) {
                product = product * nums[j];
                max = Math.max(max, product);
            }
        }
        return max;
    }

    /**
     * better solution
     *
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        // dp[i] 以 i 结尾的最大的/最小的
        int imax = nums[0];
        int imin = nums[0];
        int max = imax;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(nums[i] * imax, nums[i]);
            imin = Math.min(nums[i] * imin, nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }

}
