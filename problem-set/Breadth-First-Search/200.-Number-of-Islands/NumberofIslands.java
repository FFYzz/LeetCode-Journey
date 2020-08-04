/**
 * @Title: 200. Number of Islands
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/8/4
 */
public class NumberofIslands {

    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    ++numberOfIslands;
                }
            }
        }
        System.out.println(numberOfIslands);
        return numberOfIslands;
    }

    public void dfs(int x, int y, char[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '0';
        dfs(x + 1, y, grid);
        dfs(x, y + 1, grid);
        // 必须往左以及往上寻找，因为存在往左或者往上关联的情况
        dfs(x - 1, y, grid);
        dfs(x, y - 1, grid);
    }

    public static void main(String[] args) {
        new NumberofIslands().numIslands(new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}});
    }

}
