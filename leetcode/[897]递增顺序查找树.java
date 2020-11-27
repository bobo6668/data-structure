//给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。 
//
// 
//
// 示例 ： 
//
// 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
//
//       5
//      / \
//    3    6
//   / \    \
//  2   4    8
// /        / \ 
//1        7   9
//
//输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
//
// 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
//          \
//           6
//            \
//             7
//              \
//               8
//                \
//                 9  
//
// 
//
// 提示： 
//
// 
// 给定树中的结点数介于 1 和 100 之间。 
// 每个结点都有一个从 0 到 1000 范围内的唯一整数值。 
// 
// Related Topics 树 深度优先搜索 
// 👍 120 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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
    List<Integer> nodes = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        helper(root); // 调用辅助函数
        if (nodes.isEmpty()) return null;
        TreeNode rootNew = new TreeNode(nodes.get(0)); // 新树的根节点
        TreeNode pre = rootNew; // 记录上一个节点
        for (int i = 1; i < nodes.size(); i++) { // 根据list，构造新的树
            pre.right = new TreeNode(nodes.get(i));
            pre = pre.right;
        }
        return rootNew; // 返回新树的根节点
    }
    // 辅助函数：中序遍历，并保存到list
    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        nodes.add(root.val);
        helper(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
