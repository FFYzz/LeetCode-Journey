/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/2/28
 * @Description:
 */
public class ClosestDessertCost {

    int res = 0;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        res = baseCosts[0];
        for (int baseCount : baseCosts) {
            helper(baseCount, toppingCosts, 0, target);
        }
        return res;
    }

    /**
     * @param current      当前的 cost
     * @param toppingCosts topping 数组
     * @param index        当前 topping 的 index
     * @param target       目标的 cost
     */
    public void helper(int current, int[] toppingCosts, int index, int target) {
        if (Math.abs(target - current) < Math.abs(target - res) || (Math.abs(target - current) == Math.abs(target - res) && current < res)) {
            res = current;
        }
        if (index == toppingCosts.length || current >= target) {
            return;
        }
        // 不选择当前 topping
        helper(current, toppingCosts, index + 1, target);
        // 选择一个当前 topping
        helper(current + toppingCosts[index], toppingCosts, index + 1, target);
        // 选择两个当前 topping
        helper(current + toppingCosts[index] * 2, toppingCosts, index + 1, target);
    }

    public static void main(String[] args) {
        new ClosestDessertCost().closestCost(new int[]{1, 7}, new int[]{3, 4}, 10);
    }
}
