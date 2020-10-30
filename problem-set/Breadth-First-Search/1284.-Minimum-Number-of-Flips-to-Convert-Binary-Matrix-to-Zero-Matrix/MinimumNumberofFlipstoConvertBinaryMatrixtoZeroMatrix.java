import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/26
 */
public class MinimumNumberofFlipstoConvertBinaryMatrixtoZeroMatrix {

    public int minFlips(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        int val = encode(mat);
        if (val == 0) {
            return count;
        }
        set.add(val);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(val);
        while (!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for (int k = 0; k < size; ++k) {
                int midVal = queue.poll();
                for (int i = 0; i < rows; ++i) {
                    for (int j = 0; j < cols; ++j) {
                        mat = decode(midVal, rows, cols);
                        transfer(mat, i, j);
                        int newVal = encode(mat);
                        if (newVal == 0) {
                            return count;
                        }
                        if (!set.contains(newVal)) {
                            set.add(newVal);
                            queue.offer(newVal);
                        }
                        // 恢复
                        transfer(mat, i, j);
                    }
                }
            }
        }
        return -1;
    }

    public void transfer(int[][] mat, int x, int y) {
        int[][] dirs = new int[][]{{0, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for (int i = 0; i < dirs.length; ++i) {
            int midX = x + dirs[i][0];
            int midY = y + dirs[i][1];
            if (midX >= 0 && midX < mat.length && midY >= 0 && midY < mat[0].length) {
                mat[midX][midY] ^= 1;
            }
        }
    }

    public int encode(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                res = (res << 1) + mat[i][j];
            }
        }
        return res;
    }

    public int[][] decode(int val, int rows, int cols) {
        int[][] res = new int[rows][cols];
        for (int i = rows - 1; i >= 0; --i) {
            for (int j = cols - 1; j >= 0; --j) {
                res[i][j] = val & 1;
                val = val >> 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new MinimumNumberofFlipstoConvertBinaryMatrixtoZeroMatrix().minFlips(new int[][]{{0, 0}, {0, 1}});
    }

}
