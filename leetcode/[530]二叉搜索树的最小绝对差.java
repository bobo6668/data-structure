//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 211 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode pre = null;
    public int currentDif = -1;
    public int minDif = -1;
    public int getMinimumDifference(TreeNode root) {
        // 二查搜索树的中序遍历是有序的
        // minDif 记录已知的最小值
        getMinimumDifferenceHelper(root);
        return minDif;
    }
    private void getMinimumDifferenceHelper(TreeNode root) {
        if (root == null) return;
        // 左
        getMinimumDifferenceHelper(root.left);
        // 中
        if (pre == null) minDif = -1;
        else {
            currentDif = pre.val - root.val;
            if (currentDif < 0) currentDif = -currentDif;
            if (currentDif < minDif || minDif == -1) minDif = currentDif;
        }
        pre = root; // 更新pre
        // 右
        getMinimumDifferenceHelper(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
