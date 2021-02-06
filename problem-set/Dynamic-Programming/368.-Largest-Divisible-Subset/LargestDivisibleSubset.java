import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/2/7
 * @Description:
 */
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int maxSize = 0;
        int[] dp = new int[nums.length];
        int[] preIndex = new int[nums.length];
        Arrays.fill(preIndex, -1);
        Arrays.fill(dp, 1);
        int maxIndex = -1;
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> midRes = new ArrayList<>();
            midRes.add(nums[i]);
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] % nums[i] == 0) {
                    if (1 + dp[i] > dp[j]) {
                        preIndex[j] = i;
                        dp[j] = 1 + dp[i];
                    }
                    if (dp[j] > maxSize) {
                        maxSize = dp[j];
                        maxIndex = j;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (maxIndex != -1) {
            res.add(nums[maxIndex]);
            maxIndex = preIndex[maxIndex];
        }
        if (res.size() == 0) {
            res.add(nums[0]);
        }
        return res;
    }

    public static void main(String[] args) {
        new LargestDivisibleSubset().largestDivisibleSubset(new int[]{1, 2, 3});
    }

}
