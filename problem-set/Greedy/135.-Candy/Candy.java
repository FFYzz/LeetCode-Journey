import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/2
 */
public class Candy {

    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        // 初始化为 1
        Arrays.fill(candies, 1);
        // 确保左边往右边满足条件
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // 确保右边往左边满足条件
        for (int i = ratings.length - 1; i > 0; --i) {
            if (ratings[i - 1] > ratings[i]) {
                candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
            }
        }
        // sum
        int sum = 0;
        for (int i = 0; i < candies.length; ++i) {
            sum += candies[i];
        }
        return sum;
    }

}
