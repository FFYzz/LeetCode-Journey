## 题意

### 英文

> Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
> 
> Example :
> 
> Input: root = [4,2,6,1,3,null,null]
> Output: 1
> Explanation:
> Note that root is a TreeNode object, not an array.
> 
> The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
> 
>           4
>         /   \
>       2      6
>      / \    
>     1   3  
> 
> while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
> Note:
> 
> The size of the BST will be between 2 and 100.
> The BST is always valid, each node's value is an integer, and each node's value is different.
> This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
> 
> 
> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 中文

> 给定一个二叉搜索树的根结点 root，返回树中任意两节点的差的最小值。
> 
>  
> 
> 示例：
> 
> 输入: root = [4,2,6,1,3,null,null]
> 输出: 1
> 解释:
> 注意，root是树结点对象(TreeNode object)，而不是数组。
> 
> 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
> 
>           4
>         /   \
>       2      6
>      / \    
>     1   3  
> 
> 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
>  
> 
> 注意：
> 
> 二叉树的大小范围在 2 到 100。
> 二叉树总是有效的，每个节点的值都是整数，且不重复。
> 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
> 
> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
