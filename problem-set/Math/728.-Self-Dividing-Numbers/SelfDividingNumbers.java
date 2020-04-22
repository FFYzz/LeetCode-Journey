import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 728. Self Dividing Numbers
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/22
 */
public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            if (isSelfDividingNumbers(i)) {
                res.add(i);
            }
        }
        return res;
    }

    boolean isSelfDividingNumbers(int number) {
        int copy = number;
        while (copy > 0) {
            if (copy % 10 == 0 || number % (copy % 10) != 0) {
                return false;
            }
            copy /= 10;
        }
        return true;
    }

}
