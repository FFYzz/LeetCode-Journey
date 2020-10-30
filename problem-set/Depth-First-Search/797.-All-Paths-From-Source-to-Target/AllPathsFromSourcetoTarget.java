import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/23
 */
public class AllPathsFromSourcetoTarget {

    List<List<Integer>> res = new ArrayList<>();
    int[][] graph;

    /**
     * 暴力的 dfs
     *
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, list);
        return res;
    }

    public void dfs(int currentNode, List<Integer> currentList) {
        for (int i = 0; i < graph[currentNode].length; ++i) {
            List<Integer> newList = new ArrayList<>(currentList);
            if (graph[currentNode][i] == graph.length - 1) {
                newList.add(graph.length - 1);
                res.add(newList);
                continue;
            }
            newList.add(graph[currentNode][i]);
            dfs(graph[currentNode][i], newList);
        }
    }

}
