/**
 * @Title: 1021. Remove Outermost Parentheses
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/27
 */
public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String S) {
        StringBuilder res = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) res.append('(');
            if (c == ')' && opened-- > 1) res.append(')');
        }
        return res.toString();
    }

}
