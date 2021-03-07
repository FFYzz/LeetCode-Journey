import java.util.Arrays;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/18
 */
public class BestTeamWithNoConflicts {

    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] candidate = new int[scores.length][2];
        for (int i = 0; i < scores.length; ++i) {
            candidate[i][0] = ages[i];
            candidate[i][1] = scores[i];
        }
        // 现根据 age 排序，再根据 score 排序
        Arrays.sort(candidate, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] dp = new int[scores.length];
        dp[0] = candidate[0][1];
        int max = dp[0];
        for (int i = 1; i < scores.length; ++i) {
            dp[i] = candidate[i][1];
            for (int j = 0; j < i; ++j) {
                if (candidate[j][1] <= candidate[i][1]) {
                    dp[i] = Math.max(dp[i], candidate[i][1] + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
