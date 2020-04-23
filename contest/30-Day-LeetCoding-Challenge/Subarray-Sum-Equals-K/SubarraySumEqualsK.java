/**
 * @Title: Subarray Sum Equals K
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/22
 */
public class SubarraySumEqualsK {

    /**
     * sum[j] 代表 index 从 0 -> (j-1) 的和
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int res = 0, sum[] = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length + 1; ++j) {
                if (sum[j] - sum[i] == k) {
                    ++res;
                }
            }
        }
        return res;
    }

    //1,1,1
    public static void main(String[] args) {
        new SubarraySumEqualsK().subarraySum(new int[]{1, 1, 1}, 2);
    }

}
