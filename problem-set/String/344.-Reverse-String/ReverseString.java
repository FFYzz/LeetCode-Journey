/**
 * @Title: 344. Reverse String
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/12
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int length = s.length;
        int leftPoint = 0;
        int rightPoint = length - 1;
        while (leftPoint < rightPoint) {
            char temp = s[rightPoint];
            s[rightPoint] = s[leftPoint];
            s[leftPoint] = temp;
            ++leftPoint;
            --rightPoint;
        }
    }

}
