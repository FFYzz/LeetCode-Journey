/**
 * @Title: 1130. Minimum Cost Tree From Leaf Values
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/16
 */
public class MinimumCostTreeFromLeafValues {

    public int mctFromLeafValues(int[] arr) {
        int len = arr.length;
        // dp[i][j] answer of array[i] -> array[j]
        // dp[i, j] = dp[i, k] + dp[k + 1, j] + max(arr[i, k]) * max(arr[k + 1, j])
        int[][] dp = new int[len][len];
        // max value of interval [i,j]
        int[][] maxInterval = new int[len][len];
        // dp maxInterval
        for (int i = 0; i < len; ++i) {
            int max = arr[i];
            for (int j = i; j < len; ++j) {
                if (arr[j] > max) {
                    max = arr[j];
                }
                maxInterval[i][j] = max;
            }
        }
        //init
        for (int i = 0; i < len - 1; ++i) {
            dp[i][i + 1] = arr[i] * arr[i + 1];
        }
        // dp
        for (int distance = 2; distance < len; ++distance) {
            for (int start = 0; start + distance < len; ++start) {
                int end = start + distance;
                dp[start][end] = Integer.MAX_VALUE;
                for (int interval = start; interval < end; ++interval) {
                    dp[start][end] = Math.min(dp[start][end], dp[start][interval] + dp[interval + 1][end] + maxInterval[start][interval] * maxInterval[interval + 1][end
                            ]);
                }
            }
        }
        return dp[0][len - 1];
    }

}
