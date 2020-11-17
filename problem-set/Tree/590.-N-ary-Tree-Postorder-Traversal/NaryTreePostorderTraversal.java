
import java.util.*;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/18
 */
public class NaryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    private void postOrder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); ++i) {
            postOrder(root.children.get(i), res);
        }
        res.add(root.val);
    }

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
};