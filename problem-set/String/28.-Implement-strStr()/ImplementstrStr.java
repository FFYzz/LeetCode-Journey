/**
 * @Title: 28. Implement strStr()
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/6/2
 */
public class ImplementstrStr {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() && i <= haystack.length() - needle.length(); ++i) {
            int tmpIndex = i;
            int j = 0;
            for (; j < needle.length(); ++j) {
                if (haystack.charAt(tmpIndex++) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new ImplementstrStr().strStr("mississippi", "issipi");
    }
    //"mississippi"
    //"pi"

}
