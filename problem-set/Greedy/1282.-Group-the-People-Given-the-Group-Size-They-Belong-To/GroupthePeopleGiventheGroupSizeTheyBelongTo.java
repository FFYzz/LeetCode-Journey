import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: 1282. Group the People Given the Group Size They Belong To
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/4
 */
public class GroupthePeopleGiventheGroupSizeTheyBelongTo {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; ++i) {
            if (map.containsKey(groupSizes[i])) {
                List<Integer> midList = map.get(groupSizes[i]);
                midList.add(i);
            } else {
                List<Integer> midList = new ArrayList<>();
                midList.add(i);
                map.put(groupSizes[i], midList);
            }
            if (map.get(groupSizes[i]).size() == groupSizes[i]) {
                res.add(map.get(groupSizes[i]));
                map.remove(groupSizes[i]);
            }
        }
        return res;
    }

}
