import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: 118. Pascal's Triangle
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/6/1
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) {
            return res;
        }
        for (int i = 1; i <= numRows; ++i) {
            Integer[] a = new Integer[i];
            a[0] = 1;
            a[i - 1] = 1;
            List<Integer> preList = null;
            if (i > 1) {
                preList = res.get(i - 2);
            }
            for (int j = 1; j < a.length - 1; ++j) {
                a[j] = preList.get(j - 1) + preList.get(j);
            }
            res.add(Arrays.asList(a));
        }
        return res;
    }

    public static void main(String[] args) {
        new PascalsTriangle().generate(5);
    }

}
