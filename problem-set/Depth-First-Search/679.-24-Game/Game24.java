import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/5
 */
public class Game24 {

    public boolean judgePoint24(int[] nums) {
        List<Double> initList = new ArrayList<>();
        for (int num : nums) {
            initList.add(1.0 * num);
        }
        return dfs(initList);
    }

    private boolean dfs(List<Double> initList) {
        if (initList.size() == 1) {
            return Math.abs(initList.get(0) - 24.0) < 0.0001;
        }
        for (int i = 0; i < initList.size(); ++i) {
            for (int j = i + 1; j < initList.size(); ++j) {
                for (double c : computeTwoNumbers(initList.get(i), initList.get(j))) {
                    List<Double> nextRound = new ArrayList<>();
                    nextRound.add(c);
                    for (int k = 0; k < initList.size(); ++k) {
                        if (i == k || j == k) {
                            continue;
                        }
                        nextRound.add(initList.get(k));
                    }
                    if (dfs(nextRound)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<Double> computeTwoNumbers(double a, double b) {
        return Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a);
    }

}
