/**
 * @Title: 1314. Matrix Block Sum
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/22
 */
public class MatrixBlockSum {

    /**
     * brute force
     *
     * @param mat
     * @param K
     * @return
     */
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] answer = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                answer[i][j] = 0;
                for (int m = Math.max(0, i - K); m <= Math.min(mat.length - 1, i + K); ++m) {
                    for (int n = Math.max(0, j - K); n <= Math.min(mat[0].length - 1, j + K); ++n) {
                        answer[i][j] += mat[m][n];
                    }
                }
            }
        }
        return answer;
    }

    /**
     * rangeSum
     *
     * @param mat
     * @param K
     * @return
     */
    public int[][] matrixBlockSum2(int[][] mat, int K) {
        int row = mat.length;
        int column = mat[0].length;
        int[][] rangeSum = new int[row + 1][column + 1];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                rangeSum[i + 1][j + 1] = rangeSum[i][j + 1] + rangeSum[i + 1][j] - rangeSum[i][j] + mat[i][j];
            }
        }
        int[][] ans = new int[row][column];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                int leftX = Math.max(0, i - K);
                int leftY = Math.max(0, j - K);
                // 注意 rangeSum 的范围
                int rightX = Math.min(row, i + K + 1);
                int rightY = Math.min(column, j + K + 1);
                ans[i][j] = rangeSum[rightX][rightY] - rangeSum[leftX][rightY] - rangeSum[rightX][leftY] + rangeSum[leftX][leftY];
            }
        }
        return ans;
    }

}
