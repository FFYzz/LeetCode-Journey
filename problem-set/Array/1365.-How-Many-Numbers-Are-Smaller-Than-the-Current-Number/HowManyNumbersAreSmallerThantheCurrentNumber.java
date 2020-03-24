/**
 * @Title: 1365. How Many Numbers Are Smaller Than the Current Number
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/25
 */
public class HowManyNumbersAreSmallerThantheCurrentNumber {

    /**
     * From DISCUSS
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            count[nums[i]]++;
        }
        for (int i = 1; i < 101; ++i) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                res[i] = 0;
            } else {
                res[i] = count[nums[i] - 1];
            }
        }
        return res;
    }

    /**
     * Time complexity O(n^2)
     * space complexity O(n)
     * BAD!
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int count = 0;
            for (int j = 0; j < nums.length; ++j) {
                if (i == j) {
                    continue;
                }
                if (nums[j] < nums[i]) {
                    count++;
                }
                res[i] = count;
            }
        }
        return res;
    }

}
