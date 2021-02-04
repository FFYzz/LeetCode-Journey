import javax.swing.plaf.metal.MetalTheme;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/1/28
 * @Description:
 */
public class ConstrainedSubsequenceSum {

    /**
     * TLE
     *
     * @param nums
     * @param k
     * @return
     */
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int max = 0;
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                max = Math.max(max, dp[j]);
            }
            dp[i] = max + nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int constrainedSubsetSum2(int[] nums, int k) {
        int[] dp = new int[nums.length];
        int res = Integer.MIN_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            int max = Math.max(0, deque.isEmpty() ? 0 : dp[deque.peekFirst()]);
            dp[i] = nums[i] + max;
            res = Math.max(res, dp[i]);
            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i - deque.peekFirst() + 1 > k) {
                deque.pollFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new ConstrainedSubsequenceSum().constrainedSubsetSum(new int[]{10,2,-10,5,20}, 2);
    }

}
