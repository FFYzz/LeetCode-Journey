import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/21
 */
public class MaximumDepthofNaryTree {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ++level;
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                for (Node n : node.children) {
                    if (n != null) {
                        queue.offer(n);
                    }
                }
                --size;
            }
        }
        return level;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

}
