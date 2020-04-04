/**
 * @Title: 283. Move Zeroes
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/4
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        // 非零元素下标
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                ++index;
            }
        }
    }

}
