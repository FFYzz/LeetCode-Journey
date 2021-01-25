/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/1/26
 * @Description:
 */
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n + 1; ++i) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < m + 1; ++j) {
                dp[j][i] = dp[j - 1][i];
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[j][i] += dp[j - 1][i - 1];
                }
            }
        }
        return dp[m][n];
    }

}
