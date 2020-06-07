/**
 * @Title: 209. Minimum Size Subarray Sum
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/6/6
 */
public class MinimumSizeSubarraySum {

    /**
     * two pointer solution
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0, sum = 0, res = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= s) {
                res = Math.min(res, j - i);
                sum -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
