import java.util.Arrays;

/**
 * @Title: 698. Partition to K Equal Sum Subsets
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/10
 */
public class PartitiontoKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int average = sum / k;
        boolean[] visited = new boolean[nums.length];
        return helper(0, nums, visited, k, average, 0);
    }

    /**
     * @param start   开始寻找的位置
     * @param nums    传入数组
     * @param visited 记录是否已经访问
     * @param k       剩余待找的组数
     * @param target  平均值
     * @param sum     当前寻找周期的和
     * @return
     */
    public boolean helper(int start, int[] nums, boolean[] visited, int k, int target, int sum) {
        if (k == 1) {
            return true;
        }
        if (sum == target) {
            return helper(0, nums, visited, k - 1, target, 0);
        }
        for (int i = start; i < nums.length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                if (helper(i + 1, nums, visited, k, target, sum + nums[i])) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new PartitiontoKEqualSumSubsets().canPartitionKSubsets(new int[]{10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6}, 3);
    }

}
