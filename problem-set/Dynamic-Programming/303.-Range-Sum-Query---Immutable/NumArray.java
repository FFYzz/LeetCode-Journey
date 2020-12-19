/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/19
 */
public class NumArray {

    private int[] sum;
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            sum[i] = nums[i] + (i > 0 ? sum[i - 1] : 0);
        }
    }

    public int sumRange(int i, int j) {
        return sum[j] - sum[i] + nums[i];
    }

}
