/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/1/3
 */
public class MinimumASCIIDeleteSumforTwoStrings {

    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 0 表示字符串的长度为 0
        for (int i = 0; i <= len1; ++i) {
            for (int j = 0; j <= len2; ++j) {
                if (i == 0 || j == 0) {
                    int count = 0, klen = Math.max(i, j);
                    for (int k = 1; k <= klen; ++k) {
                        count += (i == 0 ? s2.charAt(k - 1) : s1.charAt(k - 1));
                    }
                    dp[i][j] = count;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(s1.charAt(i - 1) + dp[i - 1][j], s2.charAt(j - 1) + dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], s1.charAt(i - 1) + s2.charAt(j - 1) + dp[i - 1][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

}
