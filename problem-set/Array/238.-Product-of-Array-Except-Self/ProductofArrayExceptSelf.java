import java.util.Arrays;

/**
 * @Title: 238. Product of Array Except Self
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/16
 */
public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int countOfZero = 0;
        for (int num : nums) {
            if (num == 0) {
                ++countOfZero;
                continue;
            }
            product *= num;
        }
        if (countOfZero == nums.length) {
            return nums;
        }
        if (countOfZero > 1) {
            Arrays.fill(nums, 0);
        } else if (countOfZero == 1) {
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == 0) {
                    nums[i] = product;
                } else {
                    nums[i] = 0;
                }
            }
        } else {
            for (int i = 0; i < nums.length; ++i) {
                nums[i] = product / nums[i];
            }
        }
        return nums;
    }

}
