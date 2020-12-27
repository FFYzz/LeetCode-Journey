/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/27
 */
public class WhereWilltheBallFall {

    public int[] findBall(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] res = new int[grid[0].length];
        for (int i = 0; i < cols; ++i) {
            int row = 0, col = i;
            while (row < rows) {
                if (isStuck(grid, row, col)) {
                    res[i] = -1;
                    break;
                }
                if (grid[row][col] == 1) {
                    col++;
                } else {
                    col--;
                }
                row++;
            }
            if (row == rows) {
                res[i] = col;
            }
        }
        return res;
    }

    public boolean isStuck(int[][] grid, int row, int col) {
        if (col == 0 && grid[row][col] == -1) {
            return true;
        }
        if (col == grid[0].length - 1 && grid[row][col] == 1) {
            return true;
        }
        if (grid[row][col] == 1) {
            return col + 1 < grid[0].length && grid[row][col + 1] == -1;
        } else {
            return col - 1 > 0 && grid[row][col - 1] == 1;
        }
    }

    public static void main(String[] args) {
        new WhereWilltheBallFall().findBall(new int[][]{
                {1, 1, 1, -1, -1},
                {1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, -1, -1, -1}});
    }

}
