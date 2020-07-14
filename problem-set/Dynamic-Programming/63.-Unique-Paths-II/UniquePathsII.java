/**
 * @Title: 63. Unique Paths II
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/7/14
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, columns = obstacleGrid[0].length;
        if (rows == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[rows][columns];
        dp[0][0] = 1;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (i - 1 >= 0 && obstacleGrid[i][j] != 1) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j - 1 >= 0 && obstacleGrid[i][j] != 1) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[rows - 1][columns - 1];
    }

}
