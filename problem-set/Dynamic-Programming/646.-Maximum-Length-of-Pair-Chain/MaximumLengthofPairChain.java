import java.util.Arrays;

/**
 * @Title: 646. Maximum Length of Pair Chain
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/15
 */
public class MaximumLengthofPairChain {

    /**
     * bad solution
     * two dimensions solution
     *
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int row = pairs.length;
        // 从 i -> j 满足条件的 Pair 的对数
        int dp[][] = new int[row][row];
        // 从 i -> j 满足推荐的 Pair 的对数的最后一对的 Pair 中较大的值（第二维向量的值）
        int helpDP[][] = new int[row][row];
        // init
        for (int i = 0; i < row; ++i) {
            dp[i][i] = 1;
            helpDP[i][i] = pairs[i][1];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; ++i) {
            for (int j = i + 1; j < row; ++j) {
                if (pairs[j][0] > helpDP[i][j - 1]) {
                    dp[i][j] = dp[i][j - 1] + 1;
                    helpDP[i][j] = pairs[j][1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                    helpDP[i][j] = helpDP[i][j - 1];
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max == Integer.MIN_VALUE ? 1 : max;
    }

    /**
     * better solution
     *
     * @param pairs
     * @return
     */
    public int findLongestChain2(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        // dp[i] 表示 0,1,...,i - 1, 到 i 构成的最长的满足条件的 Pair 的长度
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < pairs.length; ++i) {
            for (int j = 0; j < i; ++j) {
                dp[i] = Math.max(dp[i], dp[j] + (pairs[i][0] > pairs[j][1] ? 1 : 0));
            }
        }
        return dp[pairs.length - 1];
    }

}
