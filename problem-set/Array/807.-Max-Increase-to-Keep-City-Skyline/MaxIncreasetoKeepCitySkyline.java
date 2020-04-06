/**
 * @Title: 807. Max Increase to Keep City Skyline
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/6
 */
public class MaxIncreasetoKeepCitySkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row = new int[grid.length];
        int[] column = new int[grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                row[i] = row[i] > grid[i][j] ? row[i] : grid[i][j];
                column[j] = column[j] > grid[i][j] ? column[j] : grid[i][j];
            }
        }

        int res = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                res += Math.min(row[i], column[j]) - grid[i][j];
            }
        }

        return res;
    }

}
