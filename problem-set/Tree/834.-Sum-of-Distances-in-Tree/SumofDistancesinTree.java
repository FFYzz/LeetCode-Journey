import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/11
 */
public class SumofDistancesinTree {

    List<Set<Integer>> nodes;
    int[] count;
    int[] res;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        nodes = new ArrayList<>();
        count = new int[N];
        res = new int[N];
        for (int i = 0; i < N; ++i) {
            nodes.add(new HashSet<Integer>());
        }
        for (int i = 0; i < edges.length; ++i) {
            nodes.get(edges[i][0]).add(edges[i][1]);
            nodes.get(edges[i][1]).add(edges[i][0]);
        }
        postOrder(0, -1);
        preOrder(0, -1);
        return res;
    }

    private void preOrder(int root, int pre) {
        for (int index : nodes.get(root)) {
            if (index == pre) {
                continue;
            }
            res[index] = res[root] - count[index] + nodes.size() - count[index];
            preOrder(index, root);
        }
    }

    private void postOrder(int root, int pre) {
        for (int index : nodes.get(root)) {
            if (index == pre) {
                continue;
            }
            postOrder(index, root);
            count[root] += count[index];
            res[root] += count[index] + res[index];
        }
        ++count[root];
    }


}
