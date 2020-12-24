import java.util.HashMap;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/25
 */
public class LongestArithmeticSubsequence {

    public int longestArithSeqLength(int[] A) {
        int len = A.length;
        int res = 2;
        HashMap<Integer, Integer>[] map = new HashMap[len];
        for (int i = 0; i < A.length; ++i) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; ++j) {
                int diff = A[i] - A[j];
                map[i].put(diff, map[j].getOrDefault(diff, 1) + 1);
                res = Math.max(map[i].get(diff), res);
            }
        }
        return res;
    }

}
