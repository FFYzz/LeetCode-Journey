/**
 * @Title: 1277. Count Square Submatrices with All Ones
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/23
 */
public class CountSquareSubmatriceswithAllOnes {

    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int res = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (matrix[i][j] == 1 && i > 0 && j > 0) {
                    matrix[i][j] = 1 + Math.min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i][j - 1]);
                }
                res += matrix[i][j];
            }
        }
        return res;
    }

}
