import java.util.*;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/10
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> duplicated = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            int sum = 0 - nums[i];
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; ++j) {
                if (set.contains(sum - nums[j])) {
                    List<Integer> subRes = new ArrayList<>();
                    subRes.add(nums[i]);
                    subRes.add(sum - nums[j]);
                    subRes.add(nums[j]);
                    Collections.sort(subRes);
                    if (duplicated.contains(subRes)) {
                        continue;
                    } else {
                        duplicated.add(subRes);
                        res.add(subRes);
                    }
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return res;
    }

    // [-1,0,1,2,-1,-4]

}

