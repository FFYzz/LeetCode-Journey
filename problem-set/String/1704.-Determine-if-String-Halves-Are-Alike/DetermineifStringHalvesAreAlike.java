import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/27
 */
public class DetermineifStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        Set<Character> set = new HashSet<>(list);
        int length = s.length();
        int i = 0, j = length - 1;
        int count = 0;
        while (i < j) {
            if (set.contains(s.charAt(i))) {
                ++count;
            }
            if (set.contains(s.charAt(j))) {
                --count;
            }
            ++i;
            --j;
        }
        return count == 0;
    }

}
