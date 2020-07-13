/**
 * @Title: 62. Unique Paths
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/7/13
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i][j - 1];
                }
                if (i - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        new UniquePaths().uniquePaths(7, 3);
    }

}
