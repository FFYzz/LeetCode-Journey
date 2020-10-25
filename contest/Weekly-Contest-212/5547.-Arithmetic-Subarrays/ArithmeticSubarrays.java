import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/25
 */
public class ArithmeticSubarrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; ++i) {
            if (r[i] - l[i] < 1) {
                res.add(false);
            } else if (r[i] - l[i] == 1) {
                res.add(true);
            } else {
                int[] tmpArr = new int[r[i] - l[i] + 1];
                for (int j = 0; j < tmpArr.length; ++j) {
                    tmpArr[j] = nums[l[i] + j];
                }
                Arrays.sort(tmpArr);
                if (isArithmetic(tmpArr)) {
                    res.add(true);
                } else {
                    res.add(false);
                }
            }
        }
        return res;
    }

    private boolean isArithmetic(int[] tmpArr) {
        int distance = tmpArr[1] - tmpArr[0];
        for (int i = 2; i < tmpArr.length; ++i) {
            if (tmpArr[i] - tmpArr[i - 1] != distance) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new ArithmeticSubarrays().checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5});
    }

}
