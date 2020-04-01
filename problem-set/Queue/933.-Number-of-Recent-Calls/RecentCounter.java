import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title: 933. Number of Recent Calls
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/1
 */
public class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList();
    }

    public int ping(int t) {
        while (queue.size() > 0 && (t - queue.peek()) > 3000) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
