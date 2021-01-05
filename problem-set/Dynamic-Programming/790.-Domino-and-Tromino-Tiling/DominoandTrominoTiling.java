/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/1/6
 */
public class DominoandTrominoTiling {

    public int numTilings(int N) {
        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= N; ++i) {
            dp[i] = 2 * dp[i - 1] + dp[i - 3];
            dp[i] %= 1000000007;
        }
        return (int) dp[N];
    }

}
