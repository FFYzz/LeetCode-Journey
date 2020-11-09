import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/9
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (isLeftParentheses(c)) {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (!match(stack.pop(), c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isLeftParentheses(char c) {
        return c == '{' || c == '[' || c == '(';
    }

    public boolean match(char x, char y) {
        return (x == '(' && y == ')') || (x == '{' && y == '}') || (x == '[' && y == ']');
    }

}
