//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 257 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;
import java.util.List;

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
    public int sumOfLeftLeaves(TreeNode root) {
        // 增加一个参数，标志是其父节点的左儿子(-1)还是右儿子(1)，以辅助判断叶子是不是左叶子
        return sumOfLeftLeavesHelper(root, 0); // 根节点没有父节点，pos初始化为0
    }
    private int sumOfLeftLeavesHelper(TreeNode root, int pos) {
        // 空节点
        if (root == null) return 0;
        // 叶子节点
        if (root.left == null && root.right == null) {
            if (pos == -1) return root.val; // 左叶子
            return 0;
        }
        // 其他节点：递归遍历，并把返回值加起来【√】
        return sumOfLeftLeavesHelper(root.left, -1) + sumOfLeftLeavesHelper(root.right, 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
