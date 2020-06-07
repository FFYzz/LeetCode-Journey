/**
 * @Title: 485. Max Consecutive Ones
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/6/6
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int startIndex = 0, maxLength = 0;
        boolean consecutive = false;
        for (int i = 0; i < nums.length; ++i) {
            if ((!consecutive && nums[i] == 0) || (consecutive && nums[i] == 1)) {
                continue;
            }
            if (nums[i] == 1) {
                startIndex = i;
                consecutive = true;
            } else {
                maxLength = Math.max(maxLength, i - startIndex);
                consecutive = false;
            }
        }
        if (consecutive) {
            maxLength = Math.max(maxLength, nums.length - startIndex);
        }
        return maxLength;
    }

    /**
     * concise solution
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes2(int[] nums) {
        int count = 0, maxLength = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                ++count;
                maxLength = Math.max(count, maxLength);
            } else {
                count = 0;
            }
        }
        return maxLength;
    }

}
