/**
 * @Title: 641. Design Circular Deque
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/16
 */
public class MyCircularDeque {

    private int head;
    private int tail;
    private int count;
    private int[] data;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        data = new int[k];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (!isFull()) {
            data[head] = value;
            head++;
            if (head == data.length) {
                head = 0;
            }
            count++;
            return true;
        }
        return false;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (!isFull()) {
            tail--;
            if (tail == -1) {
                tail = data.length - 1;
            }
            data[tail] = value;
            count++;
            return true;
        }
        return false;

    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (!isEmpty()) {
            head--;
            if (head == -1) {
                head = data.length - 1;
            }
            count--;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (!isEmpty()) {
            tail++;
            if (tail == data.length) {
                tail = 0;
            }
            count--;
            return true;
        }
        return false;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (!isEmpty()) {
            return data[(head - 1) < 0 ? data.length - 1 : (head - 1)];
        }
        return -1;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (!isEmpty()) {
            return data[tail];
        }
        return -1;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return count == data.length;
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(8);
        System.out.println();

        //["MyCircularDeque","insertFront","getFront","isEmpty","deleteFront","insertLast","getRear","insertLast","insertFront","deleteLast","insertLast","isEmpty"]
        //[[8],[5],[],[],[],[3],[],[7],[7],[],[4],[]]
    }

}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */