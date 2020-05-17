import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Title: 438. Find All Anagrams in a String
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/17
 */
public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int begin = 0, end = 0, count = map.size();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    count--;
                }
            }
            end++;
            while (count == 0) {
                char beginc = s.charAt(begin);
                if (map.containsKey(beginc)) {
                    map.put(beginc, map.get(beginc) + 1);
                    if (map.get(beginc) > 0) {
                        count++;
                    }
                }
                if (end - begin == p.length()) {
                    res.add(begin);
                }
                begin++;
            }
        }
        return res;
    }


}
