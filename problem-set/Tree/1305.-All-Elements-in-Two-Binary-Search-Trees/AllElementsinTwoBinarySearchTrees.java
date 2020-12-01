import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/1
 */
public class AllElementsinTwoBinarySearchTrees {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();
        inOrder(root1, tree1);
        inOrder(root2, tree2);
        List<Integer> res = new ArrayList<>();
        merge(tree1, tree2, res);
        return res;
    }

    private void inOrder(TreeNode root1, List<Integer> list) {
        if (root1 == null) {
            return;
        }
        inOrder(root1.left, list);
        list.add(root1.val);
        inOrder(root1.right, list);
    }

    public void merge(List<Integer> list1, List<Integer> list2, List<Integer> res) {
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                res.add(list1.get(i++));
            } else {
                res.add(list2.get(j++));
            }
        }
        while (i < list1.size()) {
            res.add(list1.get(i++));
        }
        while (j < list2.size()) {
            res.add(list2.get(j++));
        }
    }

}
