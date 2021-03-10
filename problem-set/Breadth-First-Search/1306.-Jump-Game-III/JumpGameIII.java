import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/3/10
 * @Description:
 */
public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        // save index
        Deque<Integer> queue = new LinkedList<>();
        int maxIndex = arr.length - 1;
        boolean[] flag = new boolean[arr.length];
        if (start < 0 || start > maxIndex) {
            return false;
        }
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int currIndex = queue.poll();
                if (flag[currIndex] == true) {
                    continue;
                }
                flag[currIndex] = true;
                if (arr[currIndex] == 0) {
                    return true;
                }

                int leftIndex = currIndex - arr[currIndex];
                int rightIndex = currIndex + arr[currIndex];
                if (leftIndex >= 0) {
                    queue.offer(leftIndex);
                }
                if (rightIndex <= maxIndex) {
                    queue.offer(rightIndex);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new JumpGameIII().canReach(new int[]{0, 1}, 1);
    }

}
