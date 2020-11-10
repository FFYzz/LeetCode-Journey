/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/10
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int calSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            calSum += nums[i];
            sum += i;
        }
        sum += nums.length;
        return sum - calSum;
    }


}
