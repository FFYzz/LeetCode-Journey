/**
 * @Title: 747. Largest Number At Least Twice of Others
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/19
 */
public class LargestNumberAtLeastTwiceofOthers {

    public int dominantIndex(int[] nums) {
        int max = nums[0], maxIndex = 0;
        for (int i = 1; i < nums.length; ++i) {
            max = nums[i] > max ? nums[i] : max;
            maxIndex = max == nums[i] ? i : maxIndex;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (i == maxIndex) {
                continue;
            }
            if (max < nums[i] * 2) {
                return -1;
            }
        }
        return maxIndex;
    }

}
