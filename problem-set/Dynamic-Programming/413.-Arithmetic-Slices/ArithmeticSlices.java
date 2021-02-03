/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/20
 */
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        if (A.length <= 2) {
            return 0;
        }
        int curr = 0, sum = 0;
        for (int i = 2; i < A.length; ++i) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                ++curr;
                sum += curr;
            } else {
                curr = 0;
            }
        }
        return sum;
    }

}
