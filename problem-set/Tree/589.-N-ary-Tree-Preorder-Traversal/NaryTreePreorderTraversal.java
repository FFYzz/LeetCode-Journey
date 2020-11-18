import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/19
 */
public class NaryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        preOrder(root, res);
        return res;
    }

    public void preOrder(Node node, List<Integer> res) {
        res.add(node.val);
        if (node.children != null) {
            for (int i = 0; i < node.children.size(); ++i) {
                preOrder(node.children.get(i), res);
            }
        }
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
