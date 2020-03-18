import java.util.Stack;

/**
 * @Title: 1003. Check If Word Is Valid After Substitutions
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/18
 */
public class CheckIfWordIsValidAfterSubstitutions {

    /**
     * bad solution
     *
     * @param S
     * @return
     */
    public boolean isValid(String S) {
        int len = S.length();
        if (len % 3 != 0) {
            return false;
        }
        int[] arr = new int[3];
        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();
        for (char ch : chars) {
            arr[ch - 'a']++;
            stack.push(ch);
            if (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 3; ++i) {
                    sb.append(stack.pop());
                    arr[i]--;
                }
                if (!sb.toString().equals("cba")) {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }

    /**
     * better solution
     *
     * @param S
     * @return
     */
    public boolean isValid2(String S) {
        int len = S.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; ++i) {
            if (S.charAt(i) != 'c') {
                stack.push(S.charAt(i));
            } else {
                if (!(!stack.isEmpty() && stack.pop() == 'b' && !stack.isEmpty() && stack.pop() == 'a')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
