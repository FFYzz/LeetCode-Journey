/**
 * @Title: 678. Valid Parenthesis String
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/16
 */
public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        return isValid(s, 0, 0);
    }

    /**
     * backtracking
     *
     * @param s
     * @param start
     * @param count
     * @return
     */
    public boolean isValid(String s, int start, int count) {
        if (count < 0) {
            return false;
        }
        for (int i = start; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                if (count == 0) {
                    return false;
                }
                count--;
            } else {
                return isValid(s, i + 1, count) || isValid(s, i + 1, count + 1) || isValid(s, i + 1, count - 1);
            }
        }
        return count == 0;
    }

}
