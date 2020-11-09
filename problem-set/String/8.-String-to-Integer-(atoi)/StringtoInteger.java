/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/9
 */
public class StringtoInteger {

    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0 || (!Character.isDigit(s.charAt(0)) && (s.charAt(0) != '+' && s.charAt(0) != '-'))) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        boolean isNegative = s.charAt(0) == '-';
        int index = 0;
        if (s.charAt(0) == '-') {
            sb.append('-');
            index++;
        } else if (s.charAt(0) == '+') {
            sb.append('+');
            index++;
        } else {
            sb.append('+');
        }
        boolean isLeadingZero = true;
        for (int i = index; i < s.length(); ++i) {
            if (isLeadingZero && s.charAt(i) == '0') {
                continue;
            }
            isLeadingZero = false;
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            sb.append(s.charAt(i));
        }
        if (sb.length() == 1) {
            return 0;
        }
        String max = "+" + Integer.MAX_VALUE;
        String min = String.valueOf(Integer.MIN_VALUE);
        if (isNegative && (sb.toString().length() > min.length() || sb.toString().length() == min.length() && sb.toString().compareTo(min) >= 0)) {
            return Integer.MIN_VALUE;
        }
        if (!isNegative && (sb.toString().length() > max.length() || sb.toString().length() == max.length() && sb.toString().compareTo(max) >= 0)) {
            return Integer.MAX_VALUE;
        }
        return isNegative ? 0 - Integer.valueOf(sb.substring(1)) : Integer.valueOf(sb.substring(1));
    }

}
