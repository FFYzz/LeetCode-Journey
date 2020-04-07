/**
 * @Title: 1281. Subtract the Product and Sum of Digits of an Integer
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/4
 */
public class SubtracttheProductandSumofDigitsofanInteger {

    public int subtractProductAndSum(int n) {
        int produce = 1;
        int sum = 0;
        while (n != 0) {
            produce *= (n % 10);
            sum += (n % 10);
            n /= 10;
        }
        return produce - sum;
    }

}