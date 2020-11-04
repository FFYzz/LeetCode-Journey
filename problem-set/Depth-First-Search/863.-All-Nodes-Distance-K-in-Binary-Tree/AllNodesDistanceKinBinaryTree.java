import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/4
 */
public class AllNodesDistanceKinBinaryTree {

    /**
     * 保存 target 祖先节点与 target 节点的距离
     */
    private HashMap<TreeNode, Integer> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        // 初始化 map
        find(root, target, k);
        dfs(root, target, k, map.get(root), res);
        return res;
    }

    private void dfs(TreeNode root, TreeNode target, int k, int length, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (map.containsKey(root)) {
            // 遍历经过这里时 length 会被设置成为 0
            length = map.get(root);
        }
        if (length == k) {
            list.add(root.val);
        }
        dfs(root.left, target, k, length + 1, list);
        dfs(root.right, target, k, length + 1, list);
    }

    private int find(TreeNode root, TreeNode target, int K) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        // 往左边找
        int left = find(root.left, target, K);
        // 说明在左边找到了 target
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        // 往右边找
        int right = find(root.right, target, K);
        // 说明在右边找到了 target
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(7);
        TreeNode n9 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n8;
        n5.right = n9;
        n3.left = n6;
        n3.right = n7;
        new AllNodesDistanceKinBinaryTree().distanceK(n1, n2, 2);
    }


}
