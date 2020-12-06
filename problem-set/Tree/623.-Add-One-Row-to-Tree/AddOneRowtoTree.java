import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/6
 */
public class AddOneRowtoTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        Queue<TreeNode> queue = new LinkedList<>();
        int currentLevel = 1;
        List<TreeNode> preNodes = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (currentLevel == d) {
                if (preNodes.size() == 0) {
                    TreeNode newRoot = new TreeNode(v);
                    newRoot.left = root;
                    return newRoot;
                }
                for (int i = 0; i < preNodes.size(); ++i) {
                    TreeNode currentNode = preNodes.get(i);
                    TreeNode left = new TreeNode(v);
                    TreeNode right = new TreeNode(v);
                    left.left = currentNode.left;
                    right.right = currentNode.right;
                    currentNode.left = left;
                    currentNode.right = right;
                }
                ++currentLevel;
                break;
            }
            preNodes.clear();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode currentNode = queue.poll();
                preNodes.add(currentNode);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            ++currentLevel;
        }
        if (currentLevel == d) {
            for (int i = 0; i < preNodes.size(); ++i) {
                preNodes.get(i).left = new TreeNode(v);
                preNodes.get(i).right = new TreeNode(v);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
//        TreeNode t5 = new TreeNode(1);
//        TreeNode t6 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
//        t2.right = t5;
//        t3.left = t6;
        new AddOneRowtoTree().addOneRow(t1, 5, 4);

    }
}
