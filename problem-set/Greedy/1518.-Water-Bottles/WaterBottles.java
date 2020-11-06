/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/6
 */
public class WaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles, numOfEmptyLeft = numBottles;
        while (numOfEmptyLeft >= numExchange) {
            int multi = numOfEmptyLeft / numExchange;
            count += multi;
            numOfEmptyLeft = numOfEmptyLeft - multi * numExchange + multi;
        }
        return count;
    }

    // 9 3

}
