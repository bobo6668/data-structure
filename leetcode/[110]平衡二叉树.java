//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 
// 👍 525 👎 0


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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true; // 特殊情况：节点为空，认为是平衡
        // 采用先序遍历所有节点，逐个判断是否平衡
        // ① 判断当前节点是否平衡
        int balanceFactor = hight(root.left) - hight(root.right);
        if (balanceFactor < -1 || balanceFactor > 1) return false;
        // ② 判断左子树、右子树是否平衡
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int hight(TreeNode root) { // 计算树的高度
        if (root == null) return 0; // 特殊情况：空树为0
        int leftHight = hight(root.left); // 左子树高度
        int rightHight = hight(root.right); // 右子树高度
        int Hight = leftHight > rightHight ? leftHight : rightHight;
        return Hight + 1; // 该树的高度为左右子树高度之中最大的一个，并+1（因为1个节点的高度为1）
    }
}
//leetcode submit region end(Prohibit modification and deletion)
