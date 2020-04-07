import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title: 49. Group Anagrams
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/6
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; ++i) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            if (map.containsKey(String.valueOf(chars))) {
                map.get(String.valueOf(chars)).add(strs[i]);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(String.valueOf(chars), list);
            }
        }
        return map.values().stream().collect(Collectors.toList());
    }

}
