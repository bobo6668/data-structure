//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 93 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

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
    private int res = 0;
    private int count = 0;
    public int kthLargest(TreeNode root, int k) {
        kthLargestHelper(root, k);
        return res;
    }
    public void kthLargestHelper(TreeNode root, int k) {
        if (count < k) {
            // 二叉搜索树的中序遍历是递增的
            // 那么反过来，右、中、左，则得到的是递减的。这样就不需要遍历所有节点，也可以找到第k大的节点
            if (root == null) return;
            kthLargestHelper(root.right, k);
            count ++;
            if (count == k)
                res = root.val;
            kthLargestHelper(root.left, k);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
