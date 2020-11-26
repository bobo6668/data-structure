//给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树不应
//该改变保留在树中的元素的相对结构（即，如果没有被移除，原有的父代子代关系都应当保留）。 可以证明，存在唯一的答案。 
//
// 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,0,2], low = 1, high = 2
//输出：[1,null,2]
// 
//
// 示例 2： 
//
// 
//输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
//输出：[3,2,null,1]
// 
//
// 示例 3： 
//
// 
//输入：root = [1], low = 1, high = 2
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,null,2], low = 1, high = 3
//输出：[1,null,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2], low = 2, high = 4
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数在范围 [1, 104] 内 
// 0 <= Node.val <= 104 
// 树中每个节点的值都是唯一的 
// 题目数据保证输入是一棵有效的二叉搜索树 
// 0 <= low <= high <= 104 
// 
// Related Topics 树 
// 👍 315 👎 0


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
    // 二查搜索树的中序遍历是有序的(递增)
    // 但这道题用前序遍历比较容易判断，因为先看当前节点
    // 往左儿子找low: 若比low小，则往右儿子找。然后重复上述过程
    // 往右儿子找high: 若比high大，则往左儿子找。然后重复上述过程
    // 何时停止？刚好遇到边界？【×】
    // 若遇到空节点？【×】需要想清楚递归函数的返回值

    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 返回值：返回的是符合区间上下限范围的节点。一般是root，也有可能不是
        // 若root为空，那肯定已经没有选择了，返回空
        if (root == null) return null;
        // 先序遍历
        // 中：判断root.val是否满足上下限要求。若符合，则返回root(最后一行); 若不符合，则要找节点替代root返回
        // 如果小于low，则往右子树找符合上下限要求的节点，然后代替root返回
        if (root.val < low) return trimBST(root.right, low, high);
        // 如果大于up，则往左子树找符合上下限要求的节点，然后代替root返回
        if (root.val > high) return trimBST(root.left, low, high);
        // 左, 右：递归
        root.left = trimBST(root.left, low, high); // root.left接入符合条件的左孩子
        root.right = trimBST(root.right, low, high); // root.right接入符合条件的右孩子
        // 若走到这一步，则说明无特殊情况，即root.val满足上下限范围，直接返回root
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
