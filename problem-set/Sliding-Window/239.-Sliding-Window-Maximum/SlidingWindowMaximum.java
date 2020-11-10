import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/9
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int resIndex = 0;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            // 将当前不在范围内的元素出队
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            // 从队尾开始，遇见比当前元素要小的，直接将该元素出队
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                res[resIndex++] = nums[queue.peek()];
            }
        }
        return res;
    }

}
