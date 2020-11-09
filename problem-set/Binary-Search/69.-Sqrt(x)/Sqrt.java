/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/9
 */
public class Sqrt {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 1, r = x;
        int res = 0;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (mid == x / mid) {
                return mid;
            }
            // 注意越界
            if (mid < x / mid) {
                l = mid + 1;
                // 只能小，不能大
                res = mid;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Sqrt().mySqrt(2147395599);
    }

}
