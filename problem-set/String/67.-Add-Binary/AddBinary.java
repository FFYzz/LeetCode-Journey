/**
 * @Title: 67. Add Binary
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/6/1
 */
public class AddBinary {

    private boolean add = false;

    public String addBinary(String a, String b) {
        int l1 = a.length() - 1, l2 = b.length() - 1;
        StringBuilder res = new StringBuilder();
        while (l1 >= 0 && l2 >= 0) {
            int currentVal = a.charAt(l1--) - '0' + b.charAt(l2--) - '0' + (add ? 1 : 0);
            if (currentVal >= 2) {
                add = true;
            } else {
                add = false;
            }
            res.insert(0, currentVal & 1);
        }
        checkLeft(a, l1, res);
        checkLeft(b, l2, res);
        if (add) {
            res.insert(0, 1);
        }
        return res.toString();
    }

    public void checkLeft(String str, int index, StringBuilder res) {
        while (index >= 0) {
            int currentVal = str.charAt(index--) - '0' + (add ? 1 : 0);
            if (currentVal == 2) {
                add = true;
            } else {
                add = false;
            }
            res.insert(0, currentVal & 1);
        }
    }

    /**
     * 更简洁的写法
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

}
