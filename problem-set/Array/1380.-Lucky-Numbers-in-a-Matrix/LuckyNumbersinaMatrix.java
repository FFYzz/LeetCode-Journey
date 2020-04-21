import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: 1380. Lucky Numbers in a Matrix
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/21
 */
public class LuckyNumbersinaMatrix {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[] rows = new int[matrix.length];
        int[] columns = new int[matrix[0].length];
        Arrays.fill(rows, 100001);
        Arrays.fill(columns, -1);
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                rows[i] = matrix[i][j] < rows[i] ? matrix[i][j] : rows[i];
                columns[j] = matrix[i][j] > columns[j] ? matrix[i][j] : columns[j];
            }
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (rows[i] == columns[j]) {
                    res.add(rows[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new LuckyNumbersinaMatrix().luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}});
    }
}
