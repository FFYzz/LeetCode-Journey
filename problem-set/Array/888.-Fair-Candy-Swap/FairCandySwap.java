import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/2
 */
public class FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {
        int sum1 = 0, sum2 = 0;
        for (int a : A) {
            sum1 += a;
        }
        for (int b : B) {
            sum2 += b;
        }
        int diff = Math.abs(sum1 - sum2);
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < B.length; ++j) {
                if (sum1 > sum2 && A[i] - B[j] == diff / 2) {
                    return new int[]{A[i], B[j]};
                }
                if (sum1 < sum2 && B[j] - A[i] == diff / 2) {
                    return new int[]{A[i], B[j]};
                }
                if (sum1 == sum2 && A[i] == B[j]) {
                    return new int[]{A[i], B[j]};
                }
            }
        }
        return null;
    }

    public int[] fairCandySwap2(int[] A, int[] B) {
        int diff = (Arrays.stream(A).sum() - Arrays.stream(B).sum()) / 2;
        Set<Integer> aSet = new HashSet<>();
        Arrays.stream(A).forEach(x -> aSet.add(x));
        for (int b : B) {
            if (aSet.contains(b + diff)) {
                return new int[]{b + diff, b};
            }
        }
        return new int[0];
    }
}
