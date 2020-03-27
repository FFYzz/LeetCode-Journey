/**
 * @Title: 1351. Count Negative Numbers in a Sorted Matrix
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/28
 */
public class CountNegativeNumbersinaSortedMatrix {

    /**
     * ++++++
     * ++++--
     * ++++--
     * +++---
     * +-----
     * +-----
     * <p>
     * 计算长方形的面积
     *
     * @param grid
     * @return
     */
    public int countNegatives(int[][] grid) {
        int count = 0, row = grid.length, changeLength = grid[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < changeLength; ++j) {
                if (grid[i][j] < 0) {
                    count += (changeLength - j) * (row - i);
                    changeLength = j;
                    break;
                }
            }
        }
        return count;
    }
}
