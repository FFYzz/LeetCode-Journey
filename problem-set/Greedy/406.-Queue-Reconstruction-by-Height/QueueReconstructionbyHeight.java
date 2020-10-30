import java.util.*;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/29
 */
public class QueueReconstructionbyHeight {

    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new ArrayList();
        Arrays.sort(people, (x, y) -> x[0] != y[0] ? y[0] - x[0] : x[1] - y[1]);
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        new QueueReconstructionbyHeight().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    }

}
