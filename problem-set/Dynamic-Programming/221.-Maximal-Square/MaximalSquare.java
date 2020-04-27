/**
 * @Title: 221. Maximal Square
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/27
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        // dp[i][j] : 代表以 (i - 1,j - 1) 为矩阵右下角坐标的矩阵能组成的最大的矩阵的边长。
        int row = matrix.length, column = matrix[0].length, res = 0, dp[][] = new int[row + 1][column + 1];
        for (int i = 1; i <= row; ++i) {
            for (int j = 1; j <= column; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res * res;
    }

}
