//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索 
// 👍 466 👎 0


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
    public boolean hasPathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        return hasPathSumHelper(root, sum, list);
    }
    private boolean hasPathSumHelper(TreeNode root, int sum, List<Integer> list) {
        // 如果节点为空，那肯定不行
        if (root == null) return false;
        // 如果为叶子节点，则判断是否符合sum
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                list.add(root.val);
                System.out.println(list.toString());
                return true;
            }
            else return false;
        };
        // 如果为普通节点，则判断剩余的部分是否跟sum-root.val相等。剩余部分包括左子树和右子树两种可能
        list.add(root.val);
        return hasPathSumHelper(root.left, sum - root.val, list) || hasPathSumHelper(root.right, sum - root.val, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
