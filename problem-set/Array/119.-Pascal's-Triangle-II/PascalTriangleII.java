import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title: 119. Pascal's Triangle II
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/6/7
 */
public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        int[] res = new int[rowIndex + 1];
        Arrays.fill(res, 1);
        for (int i = 2; i <= rowIndex; ++i) {
            int oldVal = res[0];
            for (int j = 1; j < i; ++j) {
                int temVal = oldVal + res[j];
                oldVal = res[j];
                res[j] = temVal;
            }
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    /**
     * better solution
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            for (int j = i - 1; j >= 1; --j) {
                int temp = res.get(j - 1) + res.get(j);
                res.set(j, temp);
            }
            res.add(1);
        }
        return res;
    }

}
