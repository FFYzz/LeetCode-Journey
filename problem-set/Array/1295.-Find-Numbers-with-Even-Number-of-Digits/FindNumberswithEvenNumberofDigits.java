/**
 * @Title: 1295. Find Numbers with Even Number of Digits
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/4
 */
public class FindNumberswithEvenNumberofDigits {

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i : nums) {
            int digits = 0;
            while (i != 0) {
                ++digits;
                i /= 10;
            }
            if ((digits & 1) == 0) {
                ++count;
            }
        }
        return count;
    }

    /**
     * better solution
     *
     * @param nums
     * @return
     */
    public int findNumbers2(int[] nums) {
        int count = 0;
        for (int i : nums) {
            if ((i >= 10 && i <= 99) || (i >= 1000 && i <= 9999)) {
                ++count;
            }
        }
        return count;
    }


}
