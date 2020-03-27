## 题意

### 英文

> A full binary tree is a binary tree where each node has exactly 0 or 2 children.
> 
> Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
> 
> Each node of each tree in the answer must have node.val = 0.
> 
> You may return the final list of trees in any order.
> 
>  
> 
> Example 1:
> 
> Input: 7
> Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
> Explanation:
> 
>  
> 
> Note:
> 
> 1 <= N <= 20
> 通过次数4,785提交次数6,558
> 
> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 中文

> 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
> 
> 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
> 
> 答案中每个树的每个结点都必须有 node.val=0。
> 
> 你可以按任何顺序返回树的最终列表。
> 
>  
> 
> 示例：
> 
> 输入：7
> 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
> 解释：
> 
>  
> 
> 提示：
> 
> 1 <= N <= 20
> 通过次数4,785提交次数6,558
> 
> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。