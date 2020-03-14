## 题意

### 英文

> Given a square array of integers A, we want the minimum sum of a falling path through A.
> 
> A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.
> 
>  
> 
> Example 1:
> 
> Input: [[1,2,3],[4,5,6],[7,8,9]]
> Output: 12
> Explanation: 
> The possible falling paths are:
> [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
> [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
> [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
> The falling path with the smallest sum is [1,4,7], so the answer is 12.
> 
>  
> 
> Note:
> 
> 1 <= A.length == A[0].length <= 100
> -100 <= A[i][j] <= 100
> 
> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 中文

> 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
> 
> 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
> 
>  
> 
> 示例：
> 
> 输入：[[1,2,3],[4,5,6],[7,8,9]]
> 输出：12
> 解释：
> 可能的下降路径有：
> [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
> [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
> [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
> 和最小的下降路径是 [1,4,7]，所以答案是 12。
> 
>  
> 
> 提示：
> 
> 1 <= A.length == A[0].length <= 100
> -100 <= A[i][j] <= 100
> 
> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
