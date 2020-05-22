import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Title: 451. Sort Characters By Frequency
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/22
 */
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        TreeMap<Integer, String> treeMap = new TreeMap<>((a, b) -> b - a);
        for (Map.Entry entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < (Integer) entry.getValue(); ++i) {
                sb.append(entry.getKey());
            }
            treeMap.put((Integer) entry.getValue(), treeMap.getOrDefault(entry.getValue(), "") + sb.toString());
        }
        StringBuilder res = new StringBuilder();
        for (String value : treeMap.values()) {
            res.append(value);
        }
        return res.toString();
    }

}
