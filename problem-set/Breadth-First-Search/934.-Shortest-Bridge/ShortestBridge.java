/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/31
 */
public class ShortestBridge {

    public int shortestBridge(int[][] A) {
        int row = A.length, column = A[0].length;
        // paint
        out:
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (A[i][j] == 1) {
                    paint(A, i, j);
                    break out;
                }
            }
        }
        // expand
        for (int base = 2; ; ++base) {
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < column; ++j) {
                    if (A[i][j] == base && (expand(A, i + 1, j, base) || expand(A, i - 1, j, base)
                            || expand(A, i, j + 1, base) || expand(A, i, j - 1, base))) {
                        return base - 2;
                    }
                }
            }
        }
    }

    public boolean expand(int[][] A, int i, int j, int base) {
        int row = A.length, column = A[0].length;
        if (i < 0 || j < 0 || i >= row || j >= column) {
            return false;
        }
        if (A[i][j] == 0) {
            A[i][j] = base + 1;
        }
        return A[i][j] == 1;
    }

    public void paint(int[][] A, int i, int j) {
        int row = A.length, column = A[0].length;
        if (i < 0 || i >= row || j < 0 || j >= column || A[i][j] == 0 || A[i][j] == 2) {
            return;
        }
        A[i][j] = 2;
        paint(A, i + 1, j);
        paint(A, i - 1, j);
        paint(A, i, j + 1);
        paint(A, i, j - 1);
    }

    public static void main(String[] args) {
        new ShortestBridge().shortestBridge(new int[][]{
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}});
    }

}
