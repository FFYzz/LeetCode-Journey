import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/26
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int freshCount = 0;
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] pos = queue.poll();
                for (int j = 0; j < 4; ++j) {
                    int x = directions[j][0] + pos[0];
                    int y = directions[j][1] + pos[1];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length
                            || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    --freshCount;
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return freshCount == 0 ? res - 1 : -1;
    }
}
