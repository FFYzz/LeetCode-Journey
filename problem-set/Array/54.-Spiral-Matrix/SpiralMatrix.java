import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 54. Spiral Matrix
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/31
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int rows = matrix.length, columns = matrix[0].length, count = 0;
        int toRight = matrix[0].length - 1, toDown = matrix.length - 1, toLeft = 0, toUp = 1;
        int x = 0, y = 0;
        while (count < rows * columns) {
            for (; y <= toRight; ++y) {
                res.add(matrix[x][y]);
                ++count;
            }
            if (count >= rows * columns) {
                break;
            }
            --toRight;
            --y;
            ++x;
            for (; x <= toDown; ++x) {
                res.add(matrix[x][y]);
                ++count;
            }
            if (count >= rows * columns) {
                break;
            }
            --toDown;
            --x;
            --y;
            for (; y >= toLeft; --y) {
                res.add(matrix[x][y]);
                ++count;
            }
            if (count >= rows * columns) {
                break;
            }
            ++toLeft;
            ++y;
            --x;
            for (; x >= toUp; --x) {
                res.add(matrix[x][y]);
                ++count;
            }
            if (count >= rows * columns) {
                break;
            }
            ++toUp;
            ++x;
            ++y;
        }
        return res;
    }


    public static void main(String[] args) {
        new SpiralMatrix().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

}
