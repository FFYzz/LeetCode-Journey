import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/17
 */
public class BuildanArrayWithStackOperations {

    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        String push = "Push";
        String pop = "Pop";
        int index = 1;
        for (int i = 0; i < target.length; ++i) {
            while (index++ < target[i]) {
                res.add(push);
                res.add(pop);
            }
            res.add(push);
        }
        return res;
    }

}
