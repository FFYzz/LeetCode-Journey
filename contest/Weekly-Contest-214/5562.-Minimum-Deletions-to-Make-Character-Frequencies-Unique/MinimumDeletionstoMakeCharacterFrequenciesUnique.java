import java.util.*;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/8
 */
public class MinimumDeletionstoMakeCharacterFrequenciesUnique {

    /**
     * NOT AC
     *
     * @param s
     * @return
     */
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, List<Character>> pam = new HashMap<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        map.forEach((x, y) -> {
            List<Character> list = pam.get(y);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(x);
            pam.put(y, list);
        });
        if (pam.size() == map.size()) {
            return count;
        }
        pam.forEach((x, y) -> {
            int tmpCount = 0;
            int tmpCount2 = 0;
            if (y.size() > 1) {
                for (int i = 1; i < y.size(); ++i) {
                    for (int k = x; k >= 0; --k) {
                        if (!pam.containsKey(x)) {
                            break;
                        }
                        ++tmpCount;
                    }
                    for (int k = x; ; ++k) {
                        if (!pam.containsKey(k)) {
                            break;
                        }
                        ++tmpCount2;
                    }
                    List<Character> tmpList = new ArrayList<>();
                    tmpList.add(y.get(i));
                    if (tmpCount < tmpCount2) {
                        pam.put(x - tmpCount, tmpList);
                    } else {

                    }

                }
            }
        });


        return 0;
    }

}
