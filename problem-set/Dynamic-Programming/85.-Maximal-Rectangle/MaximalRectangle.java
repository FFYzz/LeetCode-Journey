import java.util.Arrays;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/17
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] left = new int[columns];
        int[] right = new int[columns];
        int[] height = new int[columns];
        Arrays.fill(right, columns - 1);
        int res = 0;
        for (int i = 0; i < rows; ++i) {
            int lb = 0;
            for (int j = 0; j < columns; ++j) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            for (int j = 0; j < columns; ++j) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], lb);
                } else {
                    left[j] = 0;
                    lb = j + 1;
                }
            }
            int rb = columns - 1;
            for (int j = columns - 1; j >= 0; --j) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], rb);
                    res = Math.max(res, (right[j] - left[j] + 1) * height[j]);
                } else {
                    rb = j - 1;
                    right[j] = columns - 1;
                }
            }
        }
        return res;
    }
}
