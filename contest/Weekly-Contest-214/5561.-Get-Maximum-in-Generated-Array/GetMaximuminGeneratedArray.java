/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/8
 */
public class GetMaximuminGeneratedArray {

    public int getMaximumGenerated(int n) {
        if (n <= 1) {
            return n;
        }
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        int max = res[1];
        for (int i = 1; i <= n; ++i) {
            if (2 * i >= 2 && 2 * i <= n) {
                res[2 * i] = res[i];
                max = Math.max(res[2 * i], max);
            }
            if (2 * i + 1 >= 2 && 2 * i + 1 <= n) {
                res[2 * i + 1] = res[i] + res[i + 1];
                max = Math.max(res[2 * i + 1], max);
            }
        }
        return max;
    }

}
