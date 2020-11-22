//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 542 👎 0


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
    public int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0; // 记得处理特殊情况
        diameterOfBinaryTreeHelper(root); // 调用辅助函数
        return max;
    }
    // 设计一个辅助函数
    public int diameterOfBinaryTreeHelper(TreeNode root) {
        // 遍历所有节点，求出所有节点的高度
        // 当前路径长度 = 左子树的高度 + 右子树的高度
        // max
        // 又因为一棵树的高度 = max {左子树,右子树} + 1
        // 按照左、右、中遍历，即后序遍历
        if (root == null) return 0;
        // 左
        int leftHight = diameterOfBinaryTreeHelper(root.left);
        // 右
        int rightHight = diameterOfBinaryTreeHelper(root.right);
        // 中
        max = Math.max(leftHight + rightHight, max);
        return Math.max(leftHight, rightHight) + 1; // 返回该树的高度
    }

}
//leetcode submit region end(Prohibit modification and deletion)
