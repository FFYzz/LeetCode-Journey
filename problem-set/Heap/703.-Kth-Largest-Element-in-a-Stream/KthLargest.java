import java.util.PriorityQueue;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/2/15
 * @Description:
 */
public class KthLargest {
    PriorityQueue<Integer> queue;
    int size;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        size = k;
        for (int num : nums) {
            checkQueueSize(num, k);
        }
    }

    public int add(int val) {
        checkQueueSize(val, size);
        return queue.peek();
    }

    public void checkQueueSize(int value, int k) {
        if (queue.size() == k) {
            if (value > queue.peek()) {
                queue.poll();
                queue.offer(value);
            }
        } else {
            queue.offer(value);
        }
    }
}
