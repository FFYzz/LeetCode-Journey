/**
 * @Title: 557. Reverse Words in a String III
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/6/7
 */
public class ReverseWordsinaStringIII {

    public String reverseWords(String s) {
        int from = 0, to = 0;
        char[] chars = s.toCharArray();
        while (to < chars.length) {
            while (to < chars.length && chars[to] != ' ') {
                ++to;
            }
            reverse(chars, from, to - 1);
            from = to + 1;
            ++to;
        }
        return new String(chars);
    }

    public void reverse(char[] chars, int from, int to) {
        while (from < to) {
            char c = chars[from];
            chars[from++] = chars[to];
            chars[to--] = c;
        }
    }

}
