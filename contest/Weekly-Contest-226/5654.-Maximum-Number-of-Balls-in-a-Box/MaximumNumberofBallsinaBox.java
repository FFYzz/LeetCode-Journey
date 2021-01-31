/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/1/31
 * @Description:
 */
public class MaximumNumberofBallsinaBox {

    public int countBalls(int lowLimit, int highLimit) {
        int n = highLimit - lowLimit + 1;
        int[] box = new int[46];
        int max = 0, process = sum(lowLimit);
        for (int i = lowLimit; i <= highLimit; ++i) {
            if (i % 10 == 0) {
                process = sum(i);
            }
            box[process++]++;
            max = Math.max(max, box[process - 1]);
        }
        return max;
    }

    public int sum(int a) {
        int res = 0;
        while (a != 0) {
            res += a % 10;
            a /= 10;
        }
        return res;
    }

}
