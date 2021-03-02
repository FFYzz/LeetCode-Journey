import java.util.Arrays;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/3/3
 * @Description:
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            int mid = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == mid) {
                    return target;
                } else if (sum > mid) {
                    --right;
                } else {
                    ++left;
                }
                if (Math.abs(sum + nums[i] - target) < min) {
                    min = Math.abs(sum + nums[i] - target);
                    res = sum + nums[i];
                }
            }
        }
        return res;
    }

}
