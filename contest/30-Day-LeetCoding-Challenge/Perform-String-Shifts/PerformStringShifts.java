/**
 * @Title: Perform String Shifts
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/14
 */
public class PerformStringShifts {

    public String stringShift(String s, int[][] shift) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < shift.length; ++i) {
            shift(chars, shift[i][0] == 0 ? true : false, shift[i][1] % s.length());
        }
        return new String(chars);
    }

    public void shift(char[] chars, boolean left, int amount) {
        if (!left) {
            amount = chars.length - amount;
        }
        char[] chs = new char[chars.length - amount];
        for (int i = amount, count = 0; i < chars.length; ++i, ++count) {
            chs[count] = chars[i];
        }
        for (int i = amount - 1, count = chars.length - 1; i >= 0; --i, --count) {
            chars[count] = chars[i];
        }
        for (int i = 0; i < chars.length - amount; ++i) {
            chars[i] = chs[i];
        }
    }

    public String stringShift2(String s, int[][] shift) {
        char[] chars = s.toCharArray();
        int shiftCount = 0;
        for (int i = 0; i < shift.length; ++i) {
            if (shift[i][0] == 0) {
                shiftCount += shift[i][1];
            } else {
                shiftCount -= shift[i][1];
            }
        }
        shift2(chars, shiftCount > 0 ? true : false, Math.abs(shiftCount) % chars.length);
        return new String(chars);
    }

    public void shift2(char[] chars, boolean left, int amount) {
        if (!left) {
            amount = chars.length - amount;
        }
        char[] chs = new char[chars.length - amount];
        for (int i = amount, count = 0; i < chars.length; ++i, ++count) {
            chs[count] = chars[i];
        }
        for (int i = amount - 1, count = chars.length - 1; i >= 0; --i, --count) {
            chars[count] = chars[i];
        }
        for (int i = 0; i < chars.length - amount; ++i) {
            chars[i] = chs[i];
        }
    }

}
