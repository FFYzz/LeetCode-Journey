import java.util.HashMap;

/**
 * @Title: 525. Contiguous Array
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/13
 */
public class ContiguousArray {

    /**
     * 当有两次 sum 相等的时候，说明中间那一段的和为 0
     * 也就是有相同个数的 0 和 1
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0, sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += (nums[i] == 0 ? -1 : nums[i]);
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }

}
