import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/6
 */
public class MaximumPerformanceofaTeam {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] ess = new int[n][2];
        for (int i = 0; i < n; ++i) {
            ess[i] = new int[]{efficiency[i], speed[i]};
        }
        // 效率降序
        Arrays.sort(ess, (a, b) -> b[0] - a[0]);
        // 得是 long 类型
        // int 会越界
        long sumS = 0;
        long res = 0;
        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        // 效率降序
        for (int[] es : ess) {
            pq.add(es[1]);
            sumS = (sumS + es[1]);
            if (pq.size() > k) {
                sumS = sumS - pq.poll();
            }
            res = Math.max(res, (sumS * es[0]));
        }
        return (int) (res % (long) (1e9 + 7));
    }

}
