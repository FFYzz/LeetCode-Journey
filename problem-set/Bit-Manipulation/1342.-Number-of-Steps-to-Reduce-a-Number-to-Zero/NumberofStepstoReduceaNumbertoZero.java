/**
 * @Title: 1342. Number of Steps to Reduce a Number to Zero
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/29
 */
public class NumberofStepstoReduceaNumbertoZero {

    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 1) num -= 1;
            else num >>= 1;
            ++count;
        }
        return count;
    }

    public int numberOfSteps2(int num) {
        int count = 0;
        while (num > 0) {
            count += (num & 1) == 0 ? 1 : 2;
            num >>= 1;
        }
        return count - 1;
    }

}
