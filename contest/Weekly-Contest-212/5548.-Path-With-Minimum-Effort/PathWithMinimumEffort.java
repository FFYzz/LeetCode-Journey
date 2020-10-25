import java.util.Arrays;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/25
 */
public class PathWithMinimumEffort {

    /**
     * NOT AC
     *
     * @param heights
     * @return
     */
    public int minimumEffortPath(int[][] heights) {
        int[][] dp = new int[heights.length][heights[0].length];
        dp[0][0] = 0;
        for (int i = 0; i < heights.length; ++i) {
            for (int j = 0; j < heights[0].length; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int candidateTop = 0;
                int candidateLeft = 0;
                int candidateBelow = 0;
                int candidateRight = 0;
                if (i - 1 >= 0) {
                    candidateTop = Math.max(dp[i - 1][j], Math.abs(heights[i][j] - heights[i - 1][j]));
                }
                if (j - 1 >= 0) {
                    candidateLeft = Math.max(dp[i][j - 1], Math.abs(heights[i][j] - heights[i][j - 1]));
                }
                if (i + 1 < heights.length) {
                    candidateBelow = Math.max(dp[i + 1][j], Math.abs(heights[i][j] - heights[i + 1][j]));
                }
                if (j + 1 < heights[0].length) {
                    candidateRight = Math.max(dp[i][j + 1], Math.abs(heights[i][j] - heights[i][j + 1]));
                }
                dp[i][j] = Math.min(candidateTop, Math.min(candidateLeft, Math.min(candidateBelow, candidateRight)));
            }
        }
        return dp[heights.length - 1][heights[0].length - 1];
    }

}
