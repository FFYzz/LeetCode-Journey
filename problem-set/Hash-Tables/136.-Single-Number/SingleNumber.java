import java.util.Arrays;

/**
 * @Title: 136. Single Number
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/19
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (acc, element) -> (acc ^ element));
    }

    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}
