import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/3
 */
public class ShoppingOffers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shoppingOffers(price, special, needs, 0);
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int level) {
        // 剩余的也先单独买试试
        int min = invidualBuy(price, needs);
        // 购买第一个礼包
        for (int i = level; i < special.size(); ++i) {
            List<Integer> needsLeft = new ArrayList<>();
            for (int j = 0; j < needs.size(); ++j) {
                if (needs.get(j) - special.get(i).get(j) < 0) {
                    needsLeft = null;
                    break;
                }
                needsLeft.add(needs.get(j) - special.get(i).get(j));
            }
            if (needsLeft != null) {
                // 继续尝试购买当前礼包
                min = Math.min(min, special.get(i).get(special.get(i).size() - 1) + shoppingOffers(price, special, needsLeft, level));
            }
        }
        return min;
    }

    public int invidualBuy(List<Integer> price, List<Integer> needs) {
        int res = 0;
        for (int i = 0; i < needs.size(); ++i) {
            res += needs.get(i) * price.get(i);
        }
        return res;
    }


}
