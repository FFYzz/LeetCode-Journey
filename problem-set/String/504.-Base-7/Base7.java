/**
 * @Title: 504. Base 7
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/24
 */
public class Base7 {

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean isNegtive = num < 0 ? true : false;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.insert(0, num % 7);
            num /= 7;
        }
        return isNegtive ? "-" + sb.toString() : sb.toString();
    }

}
