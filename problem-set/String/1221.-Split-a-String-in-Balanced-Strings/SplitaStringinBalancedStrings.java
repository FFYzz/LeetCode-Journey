/**
 * @Title: 1221. Split a String in Balanced Strings
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/13
 */
public class SplitaStringinBalancedStrings {

    public int balancedStringSplit(String s) {
        int count = 0, res = 0;
        char c = s.charAt(0);
        for (int i = 0; i < s.length(); ++i) {
            if (c == s.charAt(i)) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                ++res;
                if (i < s.length() - 1) {
                    c = s.charAt(i + 1);
                }
            }
        }
        return res;
    }

    public int balancedStringSplit2(String s) {
        int count = 0, res = 0;
        char c = s.charAt(0);
        for (int i = 0; i < s.length(); ++i) {
            count += s.charAt(i) == 'R' ? 1 : -1;
            if (count == 0) {
                res++;
            }
        }
        return res;
    }


}
