/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/9
 */
public class ReverseStringII {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; ) {
            if (chars.length - i < k) {
                for (int j = chars.length - 1; j >= i; --j) {
                    sb.append(chars[j]);
                }
                break;
            } else if (chars.length - i >= k && chars.length - i < 2 * k) {
                for (int j = 0; j < k; ++j) {
                    sb.append(chars[i + k - j - 1]);
                }
                for (int j = i + k; j < chars.length; ++j) {
                    sb.append(chars[j]);
                }
                break;
            } else {
                for (int j = 0; j < k; ++j) {
                    sb.append(chars[i + k - j - 1]);
                }
                for (int j = i + k; j < i + 2 * k; ++j) {
                    sb.append(chars[j]);
                }
                i += 2 * k;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new ReverseStringII().reverseStr("a", 2);
    }

}
