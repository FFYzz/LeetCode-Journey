import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/2/28
 * @Description:
 */
public class CountItemsMatchingaRule {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        int targetIndex = -1;
        if (ruleKey.equals("type")) {
            targetIndex = 0;
        } else if (ruleKey.equals("color")) {
            targetIndex = 1;
        } else {
            targetIndex = 2;
        }
        for (List<String> list : items) {
            if (list.get(targetIndex).equals(ruleValue)) {
                ++res;
            }
        }
        return res;
    }

}
