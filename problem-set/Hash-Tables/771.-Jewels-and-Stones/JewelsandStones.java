import java.util.HashSet;
import java.util.Set;

/**
 * @Title: 771. Jewels and Stones
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/3
 */
public class JewelsandStones {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }

}
