/**
 * @Title: 540. Single Element in a Sorted Array
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/12
 */
public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid & 1) == 0) {
                // single element 在 mid 的右边
                if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                    left = mid + 2;
                    // single element 在 mid 左边
                } else if (mid > 0 && nums[mid] == nums[mid - 1]) {
                    right = mid - 2;
                } else {
                    return nums[mid];
                }
            } else {
                // single element 在 mid 右边
                if (mid > 0 && nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                    // single element 在 mid 左边
                } else if (mid < nums.length && nums[mid] == nums[mid + 1]) {
                    right = mid - 1;
                } else {
                    return nums[mid];
                }
            }
        }
        return -1;
    }

    /**
     * concise solution
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((mid & 1) != 0) {
                mid -= 1;
            }
            // single element 在 mid 的右边
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
                // single element 在 mid 左边
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}
