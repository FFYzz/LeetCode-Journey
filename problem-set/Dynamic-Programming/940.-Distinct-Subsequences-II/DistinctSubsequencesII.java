import java.util.Arrays;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/1/27
 * @Description:
 */
public class DistinctSubsequencesII {

    public int distinctSubseqII(String S) {
        long []counts = new long[26];
        long mod = (long)1e9 + 7;
        for (char c : S.toCharArray()) {
            counts[c - 'a'] = (Arrays.stream(counts).sum() % mod) + 1;
        }
        return (int)(Arrays.stream(counts).sum() % mod);
    }

}
