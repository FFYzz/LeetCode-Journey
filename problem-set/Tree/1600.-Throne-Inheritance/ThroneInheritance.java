import java.util.*;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/8
 */
class ThroneInheritance {

    private Set<String> deathList;

    private Map<String, TreeNode> nameMapper;

    TreeNode root;

    public ThroneInheritance(String kingName) {
        deathList = new HashSet<>();
        nameMapper = new HashMap<>();
        root = new TreeNode();
        root.name = kingName;
        root.children = new ArrayList<>();
        nameMapper.put(kingName, root);
    }

    public void birth(String parentName, String childName) {
        List<TreeNode> list = nameMapper.get(parentName).children;
        TreeNode child = new TreeNode();
        child.name = childName;
        child.children = new ArrayList<>();
        list.add(child);
        nameMapper.put(childName, child);
    }

    public void death(String name) {
        deathList.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<String> res) {
        if (root == null) {
            return;
        }
        if (!deathList.contains(root.name)) {
            res.add(root.name);
        }
        for (TreeNode children : root.children) {
            dfs(children, res);
        }
    }

    class TreeNode {
        String name;
        List<TreeNode> children;
    }
}
