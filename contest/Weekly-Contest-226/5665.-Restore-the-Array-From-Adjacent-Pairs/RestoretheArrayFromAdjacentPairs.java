import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/1/31
 * @Description:
 */
public class RestoretheArrayFromAdjacentPairs {

    public int[] restoreArray(int[][] adjacentPairs) {
        int length = adjacentPairs.length;
        int[] res = new int[length + 1];
        int index = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; ++i) {
            if (!map.containsKey(adjacentPairs[i][0])) {
                map.put(adjacentPairs[i][0], new ArrayList<>());
            }
            if (!map.containsKey(adjacentPairs[i][1])) {
                map.put(adjacentPairs[i][1], new ArrayList<>());
            }
            map.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
            map.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                res[index++] = entry.getKey();
                res[index++] = entry.getValue().get(0);
                break;
            }
        }
        while (index <= length) {
            int pre = res[index - 2];
            List<Integer> tmp = map.get(res[index - 1]);
            if (tmp.size() == 1) {
                res[index++] = tmp.get(0);
                break;
            } else {
                res[index++] = (pre == tmp.get(0) ? tmp.get(1) : tmp.get(0));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new RestoretheArrayFromAdjacentPairs().restoreArray(new int[][]
                {{2, 1}, {3, 4}, {3, 2}}
        );
    }

}