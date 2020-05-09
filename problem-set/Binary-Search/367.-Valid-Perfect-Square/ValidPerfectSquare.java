/**
 * @Title: 367. Valid Perfect Square
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/9
 */
public class ValidPerfectSquare {

    /**
     * 需要注意 int 越界的情况
     * 乘法容易越界，可以使用除法
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int left = 0, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num / mid == mid && num % mid == 0) {
                return true;
            } else if (num / mid < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new ValidPerfectSquare().isPerfectSquare(2147395600);
    }

}
