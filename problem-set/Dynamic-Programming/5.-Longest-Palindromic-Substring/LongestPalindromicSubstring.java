/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/22
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int length = s.length();
        int maxLength = -1;
        String res = String.valueOf(s.charAt(0));
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
        }
        maxLength = 1;
        for (int strLength = 2; strLength <= length; ++strLength) {
            for (int startPos = 0; startPos + strLength <= length; ++startPos) {
                // 奇数长度
                if ((strLength & 1) == 1) {
                    dp[startPos][startPos + strLength - 1] = dp[startPos + 1][startPos + strLength - 1 - 1]
                            && s.charAt(startPos) == s.charAt(startPos + strLength - 1);
                } else {
                    // 偶数长度
                    if (strLength == 2) {
                        dp[startPos][startPos + 1] = s.charAt(startPos) == s.charAt(startPos + 1);
                    } else {
                        dp[startPos][startPos + strLength - 1] = dp[startPos + 1][startPos + strLength - 1 - 1]
                                && s.charAt(startPos) == s.charAt(startPos + strLength - 1);
                    }
                }
                if (dp[startPos][startPos + strLength - 1] && strLength > maxLength) {
                    maxLength = strLength;
                    res = s.substring(startPos, startPos + strLength);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new LongestPalindromicSubstring().longestPalindrome("aaaa");
    }

}
