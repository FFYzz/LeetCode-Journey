/**
 * @Title: 26. Remove Duplicates from Sorted Array
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/6/7
 */
public class RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0, faster = 1, targetValue = nums[0];
        for (; faster < nums.length; ++faster) {
            if (nums[faster] == targetValue) {
                continue;
            }
            targetValue = nums[faster];
            nums[++slow] = targetValue;
        }
        return slow + 1;
    }

}
