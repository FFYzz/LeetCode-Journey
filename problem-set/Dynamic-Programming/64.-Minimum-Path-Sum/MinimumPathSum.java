/**
 * @Title: 64. Minimum Path Sum
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/11
 */
public class MinimumPathSum {

    // dp[m][n] 表示到位置为 grid[]m[n] 的最短路径
    // dp[m][n] = min{dp[m][n - 1],dp[m - 1][n]} + grid[m][n]

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        // init
        dp[0][0] = grid[0][0];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (i > 0 && j > 0) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i > 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else if (j > 0){
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][column - 1];
    }


}
