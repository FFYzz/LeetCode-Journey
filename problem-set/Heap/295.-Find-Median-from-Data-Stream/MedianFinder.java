import java.util.PriorityQueue;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/16
 */
public class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((x, y) -> y - x);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.size() != 0 && num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else if (minHeap.size() != 0 && num >= minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
    }

    public double findMedian() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        int midCount = (maxHeapSize + minHeapSize) / 2;
        while (minHeap.size() > midCount) {
            maxHeap.add(minHeap.poll());
        }
        while (minHeap.size() < midCount) {
            minHeap.add(maxHeap.poll());
        }

        if (((maxHeapSize + minHeapSize) & 1) == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        // ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
        // [[],[1],[2],[],[3],[]]
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
    }

}
