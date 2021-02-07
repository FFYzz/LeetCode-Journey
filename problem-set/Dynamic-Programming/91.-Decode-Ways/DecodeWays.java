/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/2/8
 * @Description:
 */
public class DecodeWays {
    public int numDecodings(String s) {
//        return s.length() == 0 ? 0 : numDecoding(0, s);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); ++i) {
            int oneBefore = Integer.valueOf(s.substring(i - 1, i));
            int twoBefore = Integer.valueOf(s.substring(i - 2, i));
            if (oneBefore >= 1 && oneBefore <= 9) {
                dp[i] = dp[i - 1];
            }
            if (twoBefore >= 10 && twoBefore <= 26) {
                dp[i] += dp[i -2];
            }
        }
        return dp[s.length()];
    }

    /**
     * TLE
     *
     * @param index
     * @param s
     * @return
     */
    private int numDecoding(int index, String s) {
        if (index == s.length()) {
            return 1;
        }
        // leading zero 的情况
        if (s.charAt(index) == '0') {
            return 0;
        }
        int res = numDecoding(index + 1, s);
        if ((index < s.length() - 1) && ((s.charAt(index) == '1') || (s.charAt(index) == '2' && s.charAt(index + 1) < '7'))) {
            res += numDecoding(index + 2, s);
        }
        return res;
    }

    public static void main(String[] args) {
        new DecodeWays().numDecodings("12");
    }

}
