import java.util.Arrays;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/15
 */
public class NRepeatedElementinSize2NArray {

    public int repeatedNTimes2(int[] A) {
        Arrays.sort(A);
        return A[0] == A[A.length / 2 - 1] ? A[0] : A[A.length / 2];
    }

    public int repeatedNTimes(int[] A) {
        int[] count = new int[10000];
        for (int a : A) {
            if (++count[a] == 1) {
                return a;
            }
        }
        return 0;
    }
}
