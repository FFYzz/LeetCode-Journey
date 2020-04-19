/**
 * @Title: 66. Plus One
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/19
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        boolean carry = false;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] == 9) {
                digits[i] = 0;
                carry = true;
            } else {
                digits[i]++;
                carry = false;
                break;
            }
        }
        int[] res = new int[digits.length + 1];
        if (carry) {
            res[0] = 1;
            for (int i = 0; i < digits.length; ++i) {
                res[i + 1] = digits[i];
            }
            return res;
        } else {
            return digits;
        }
    }

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

}
