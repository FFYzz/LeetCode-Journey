import java.util.HashMap;

/**
 * @Title: 567. Permutation in String
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/18
 */
public class PermutationinString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, count = map.size();
        while (right < s2.length()) {
            char rightChar = s2.charAt(right);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) {
                    count--;
                }
            }
            right++;
            while (count == 0) {
                char leftChar = s2.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        count++;
                    }
                }
                if (right - left == s1.length()) {
                    return true;
                }
                left++;
            }
        }
        return false;
    }

}
