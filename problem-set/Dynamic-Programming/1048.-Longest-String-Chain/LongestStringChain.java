import java.util.Arrays;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/26
 */
public class LongestStringChain {

    public int longestStrChain(String[] words) {
        if (words.length <= 1) {
            return words.length;
        }
        Arrays.sort(words, (x, y) -> x.length() - y.length());
        int[] dp = new int[words.length];
        dp[0] = 1;
        int res = 0;
        for (int i = 0; i < words.length; ++i) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0 && words[i].length() - words[j].length() <= 1; --j) {
                if ((words[i].length() == words[j].length() + 1) && (isStrChain(words[j], words[i]))) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * @param w1 较短的
     * @param w2 较长的
     * @return
     */
    private boolean isStrChain(String w1, String w2) {
        int diff = 0;
        for (int i = 0, j = 0; i < w1.length(); ) {
            if (w1.charAt(i) == w2.charAt(j)) {
                i++;
                j++;
            } else {
                diff++;
                if (diff > 1) return false;
                j++;
            }
        }
        return true;
    }

}
