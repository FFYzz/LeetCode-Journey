/**
 * @Title: 283. Move Zeroes
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/6/7
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int index = 0, countOfZero = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            } else {
                ++countOfZero;
            }
        }
        for (int i = nums.length - 1; countOfZero > 0; --i, --countOfZero) {
            nums[i] = 0;
        }
    }

}
