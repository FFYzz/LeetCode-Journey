import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: 1395. Count Number of Teams
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/11
 */
public class CountNumberofTeams {

    /**
     * use hashmap
     *
     * @param rating
     * @return
     */
    public int numTeams(int[] rating) {
        Map<Integer, ArrayList<Integer>> less = new HashMap();
        Map<Integer, ArrayList<Integer>> more = new HashMap();
        for (int i = 0; i < rating.length; ++i) {
            ArrayList<Integer> lessList = new ArrayList<>();
            ArrayList<Integer> moreList = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                if (rating[i] > rating[j]) {
                    lessList.add(j);
                }
                if (rating[i] < rating[j]) {
                    moreList.add(j);
                }
            }
            less.put(i, lessList);
            more.put(i, moreList);
        }
        int res = 0;
        for (Map.Entry entry : less.entrySet()) {
            ArrayList<Integer> integers = (ArrayList<Integer>) entry.getValue();
            for (Integer integer : integers) {
                res += less.get(integer).size();
            }
        }
        for (Map.Entry entry : more.entrySet()) {
            ArrayList<Integer> integers = (ArrayList<Integer>) entry.getValue();
            for (Integer integer : integers) {
                res += more.get(integer).size();
            }
        }
        return res;
    }

}
