/**
 * @Title: 709. To Lower Case
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/17
 */
public class ToLowerCase {

    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        int distance = 32;
        for (char ch : str.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char) (ch + distance));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public String toLowerCase2(String str) {
        char[] chs = str.toCharArray();
        int distance = 32;
        for (int i = 0; i < chs.length; ++i) {
            if (chs[i] >= 'A' && chs[i] <= 'Z') {
                chs[i] = (char) (chs[i] + distance);
            }
        }
        return new String(chs);
    }


}
