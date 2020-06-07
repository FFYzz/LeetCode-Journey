/**
 * @Title: 27. Remove Element
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/6/6
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int newIndex = 0, countIndex = 0;
        for (; countIndex < nums.length; ++countIndex) {
            if (nums[countIndex] == val) {
                continue;
            }
            nums[newIndex++] = nums[countIndex];
        }
        return newIndex;
    }

}
