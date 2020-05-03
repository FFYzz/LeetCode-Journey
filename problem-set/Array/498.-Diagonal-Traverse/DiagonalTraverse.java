/**
 * @Title: 498. Diagonal Traverse
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/20
 */
public class DiagonalTraverse {

    /**
     * 要注意顺序，因为 column 或者 row 越过底部或者右边界时，会修改 row 以及 column
     * 因此这两个判断要放在前面
     *
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        int row = 0, column = 0, d = 0;
        int[][] directions = new int[][]{{-1, 1}, {1, -1}};
        for (int i = 0; i < m * n; ++i) {
            res[i] = matrix[row][column];
            row += directions[d][0];
            column += directions[d][1];
            if (row > m - 1) {
                row = m - 1;
                column += 2;
                d = 1 - d;
            }
            if (column > n - 1) {
                column = n - 1;
                row += 2;
                d = 1 - d;
            }
            if (row < 0) {
                row = 0;
                d = 1 - d;
            }
            if (column < 0) {
                column = 0;
                d = 1 - d;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        new DiagonalTraverse().findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

}
