import java.util.Stack;

/**
 * @Title: 402. Remove K Digits
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/13
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (k == num.length() || num.length() == 0) {
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); ++i) {
            // 将栈中比当前元素大的元素都 pop
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i) - '0') {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i) - '0');
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        int leadingZeroCount = 0;
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) != '0') {
                break;
            }
            ++leadingZeroCount;
        }
        return leadingZeroCount == sb.length() ? "0" : sb.substring(leadingZeroCount, sb.length());
    }

    // "1432219"
    // 3
}
