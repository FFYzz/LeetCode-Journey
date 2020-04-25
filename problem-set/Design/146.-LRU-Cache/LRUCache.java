/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/25
 */
class LRUCache {
    int capacity;
    int size;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node loopNode = head;
        while (loopNode != null) {
            if (loopNode.key == key) {
                int res = loopNode.value;
                Node preNode = loopNode.pre;
                Node nextNode = loopNode.next;
                if (preNode != null) {
                    preNode.next = nextNode;
                } else {
                    return res;
                }
                if (nextNode != null) {
                    nextNode.pre = preNode;
                } else {
                    tail = preNode;
                }
                loopNode.next = head;
                loopNode.pre = null;
                head.pre = loopNode;
                head = loopNode;
                return res;
            } else {
                loopNode = loopNode.next;
            }
        }
        return -1;
    }

    public void modify(int key, int value) {
        Node workNode = head;
        while (workNode.key != key) {
            workNode = workNode.next;
        }
        workNode.value = value;
    }

    public void put(int key, int value) {
        int find = get(key);
        if (find != -1) {
            modify(key, value);
            get(key);
            return;
        }
        Node node = new Node(key, value);
        if (head == null) {
            node.pre = null;
            node.next = null;
            head = node;
            tail = node;
            ++size;
        } else {
            if (size < capacity) {
                node.next = head;
                node.pre = null;
                head.pre = node;
                head = node;
                ++size;
            } else {
                Node lastNode = tail;
                node.next = head;
                node.pre = null;
                head.pre = node;
                head = node;
                tail = lastNode.pre;
                if (tail != null) {
                    tail.next = null;
                } else {
                    tail = head;
                }
            }
        }
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
