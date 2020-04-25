/**
 * @Title: 55. Jump Game
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/25
 */
public class JumpGame {

    /**
     * O(n) 解法
     * 思路就是在每个位置上都尝试走最多的步数，判断最后能够走到 last index
     * 中间有个前提就是每个位置都能够走到，用了判断条件 i <= maxDis
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
//        return jump(0, nums[0], nums);
        int maxDis = 0;
        for (int i = 0; i <= maxDis; ++i) {
            maxDis = Math.max(i + nums[i], maxDis);
            if (maxDis >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 超时，最后两个 case 过不了
     *
     * @param currentIndex
     * @param canJumpSteps
     * @param nums
     * @return
     */
    public boolean jump(int currentIndex, int canJumpSteps, int[] nums) {
        if (currentIndex >= nums.length - 1) {
            return true;
        }
        boolean res = false;
        for (int i = canJumpSteps; i >= 1; --i) {
            res |= jump(currentIndex + i, currentIndex + i > nums.length - 1 ? nums.length - 1 : nums[currentIndex + i], nums);
            if (res) {
                break;
            }
        }
        return res;
    }

}
