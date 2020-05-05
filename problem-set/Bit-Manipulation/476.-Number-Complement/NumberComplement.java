/**
 * @Title: 476. Number Complement
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/4
 */
public class NumberComplement {

    public int findComplement(int num) {
        int num1 = ~num;
        int value = 1;
        while (value < num) {
            value <<= 1;
            value += 1;
        }
        return num1 & value;
    }

    public static void main(String[] args) {
        new NumberComplement().findComplement(1);
    }

}
