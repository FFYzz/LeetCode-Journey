/**
 * @Title: 918. Maximum Sum Circular Subarray
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/15
 */
public class MaximumSumCircularSubarray {

    /**
     * 额外的存储空间
     *
     * @param A
     * @return
     */
    public int maxSubarraySumCircular(int[] A) {
        int maxSum = -30000, minSum = 30000, sum = 0, maxdp[] = new int[A.length], mindp[] = new int[A.length];
        sum = A[0];
        maxdp[0] = A[0];
        mindp[0] = A[0];
        maxSum = maxdp[0];
        minSum = mindp[0];
        for (int i = 1; i < A.length; ++i) {
            sum += A[i];
            maxdp[i] = A[i] + (maxdp[i - 1] > 0 ? maxdp[i - 1] : 0);
            maxSum = Math.max(maxdp[i], maxSum);
            mindp[i] = A[i] + (mindp[i - 1] < 0 ? mindp[i - 1] : 0);
            minSum = Math.min(minSum, mindp[i]);
        }
        return maxSum < 0 ? maxSum : Math.max(maxSum, sum - minSum);
    }

    /**
     * concise solution
     *
     * @param A
     * @return
     */
    public int maxSubarraySumCircular2(int[] A) {
        int maxSum = -30000, minSum = 30000, sum = 0, curMax = 0, curMin = 0;
        for (int a : A) {
            sum += a;
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
        }
        return maxSum < 0 ? maxSum : Math.max(maxSum, sum - minSum);
    }

    public static void main(String[] args) {
        new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{5, -3, 5});
    }


}
