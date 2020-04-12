import java.util.PriorityQueue;

/**
 * @Title: 1046. Last Stone Weight
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/12
 */
public class LastStoneWeight {

    /**
     * heap
     *
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

        for (int num : stones) {
            priorityQueue.offer(num);
        }

        while (priorityQueue.size() > 1) {
            priorityQueue.offer(priorityQueue.poll() - priorityQueue.poll());
        }
        return priorityQueue.peek();
    }

}
