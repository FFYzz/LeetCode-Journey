import java.util.Arrays;

/**
 * @Title: 561. Array Partition I
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/6/3
 */
public class ArrayPartitionI {
    
    /**
     * O(nlogn)
     *
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        new ArrayPartitionI().arrayPairSum(new int[]{1, 2, 3, 4});
    }

}
