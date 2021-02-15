import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/2/15
 * @Description:
 */
public class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return getTailVal(queue1.size() == 0 ? queue2 : queue1, queue1.size() == 0 ? queue1 : queue2, true);
    }

    /**
     * Get the top element.
     */
    public int top() {
        return getTailVal(queue1.size() == 0 ? queue2 : queue1, queue1.size() == 0 ? queue1 : queue2, false);
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public int getTailVal(Queue<Integer> queue1, Queue<Integer> queue2, boolean pop) {
        int res = 0;
        while (!queue1.isEmpty()) {
            if (queue1.size() == 1) {
                res = queue1.poll();
                if (!pop) {
                    queue2.offer(res);
                }
                break;
            }
            queue2.offer(queue1.poll());
        }
        return res;
    }


}
