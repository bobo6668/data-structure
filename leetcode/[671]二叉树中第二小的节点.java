//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,2,5,null,null,5,7]
//输出：5
//解释：最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2： 
//
// 
//输入：root = [2,2,2]
//输出：-1
//解释：最小的值是 2, 但是不存在第二小的值。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 25] 内 
// 1 <= Node.val <= 231 - 1 
// 对于树中每个节点 root.val == min(root.left.val, root.right.val) 
// 
// Related Topics 树 
// 👍 123 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    protected int min = Integer.MAX_VALUE;
    protected int secondMin = Integer.MAX_VALUE;
    protected boolean secondMinFlag = false;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        // root.val是最小值
        min = root.val;
        // 遍历所有节点
        findSecondMinimumValueHelper(root);
        if (secondMinFlag) return secondMin;
        return -1;
    }
    protected void findSecondMinimumValueHelper(TreeNode root) {
        // 前序遍历
        if (root == null) return;
        // 中：
        // root.val是该树的最小值，若 >= secondMin (在已找到secondMin候选值的情况下)，则不用继续遍历该树
        if (root.val >= secondMin && secondMinFlag) return;
        // 若比min大，则更新为候选值
        if (root.val > min) {
            secondMin = root.val;
            secondMinFlag = true;
        }
        // 左、右：递归
        findSecondMinimumValueHelper(root.left);
        findSecondMinimumValueHelper(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
