import java.util.Stack;

/**
 * @Title: Backspace String Compare
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/9
 */
public class BackspaceStringCompare {

    /**
     * stack solution
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char ch : S.toCharArray()) {
            if (ch == '#' && !stack1.isEmpty()) stack1.pop();
            else if (ch != '#') stack1.push(ch);
        }
        for (char ch : T.toCharArray()) {
            if (ch == '#' && !stack2.isEmpty()) stack2.pop();
            else if (ch != '#') stack2.push(ch);
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (!stack1.pop().equals(stack2.pop())) {
                return false;
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
