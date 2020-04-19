/**
 * @Title: 724. Find Pivot Index
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/19
 */
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int leftSum = 0, rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                leftSum = 0;
                rightSum -= nums[i];
            } else if (i == nums.length - 1) {
                rightSum = 0;
                leftSum += nums[i - 1];
            } else {
                leftSum += nums[i - 1];
                rightSum -= nums[i];
            }
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int sum = 0, current = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; current += nums[i++]) {
            if (current * 2 == sum - nums[i]) {
                return i;
            }
        }
        return -1;
    }

}
