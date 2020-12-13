/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/13
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public int minPartitions(String n) {
        int res = Integer.MIN_VALUE;
        for (char c : n.toCharArray()) {
            res = Math.max(res, c - '0');
            if (res == 9) {
                return 9;
            }
        }
        return res;
    }

}
