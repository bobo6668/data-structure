//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。 
//
// 示例 1: 
//给定的树 s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t： 
//
// 
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s： 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t： 
//
// 
//   4
//  / \
// 1   2
// 
//
// 返回 false。 
// Related Topics 树 
// 👍 395 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

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
    List<TreeNode> list = new ArrayList<>();
    public boolean isSubtree(TreeNode s, TreeNode t) {
        search(s, t.val); // 遍历树s，先把树s中跟t节点一样的节点全部找出来
        for (TreeNode root : list) { // 然后逐个判断是否是完全一样的树
            if(isSameTree(root, t)) return true;
        }
        return false;
    }
    private void search(TreeNode s, int target) {
        if (s == null) return;
        // 先序遍历
        if (s.val == target) list.add(s);
        search(s.left, target);
        search(s.right, target);
    }
    private boolean isSameTree(TreeNode root, TreeNode s) {
        if (root == null && s == null) return true;
        if (root == null && s != null) return false;
        if (root != null && s == null) return false;
        if (root.val != s.val) return false;
        return isSameTree(root.left, s.left) && isSameTree(root.right, s.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
