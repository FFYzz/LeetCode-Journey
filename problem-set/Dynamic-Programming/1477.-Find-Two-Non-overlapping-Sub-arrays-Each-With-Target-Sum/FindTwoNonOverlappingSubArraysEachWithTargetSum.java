import java.util.HashMap;
import java.util.Map;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/1/15
 * @Description:
 */
public class FindTwoNonOverlappingSubArraysEachWithTargetSum {

    public int minSumOfLengths(int[] arr, int target) {
        int res = Integer.MAX_VALUE, sum = 0, l = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            map.put(sum, i);
        }
        sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                l = Math.min(l, i - map.get(sum - target));
            }
            if (map.containsKey(sum + target) && l != Integer.MAX_VALUE) {
                res = Math.min(res, (map.get(sum + target) - i + l));
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
