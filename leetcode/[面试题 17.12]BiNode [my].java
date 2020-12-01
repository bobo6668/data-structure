//二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉
//搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。 
//
// 返回转换后的单向链表的头节点。 
//
// 注意：本题相对原题稍作改动 
//
// 
//
// 示例： 
//
// 输入： [4,2,5,1,3,null,6,0]
//输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 提示： 
//
// 
// 节点数量不会超过 100000。 
// 
// Related Topics 树 二叉搜索树 递归 
// 👍 54 👎 0


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
    protected List<Integer> list = new ArrayList<>();
    public TreeNode convertBiNode(TreeNode root) {
        helper(root);
        if (list.size() == 0) return null;
        TreeNode newRoot = new TreeNode(list.get(0));
        TreeNode pre = newRoot;
        for (int i = 1; i < list.size(); i++) {
            pre.left = null;
            pre.right = new TreeNode(list.get(i));
            pre = pre.right;
        }
        return newRoot;
    }
    protected void helper(TreeNode root) {
        // 二叉搜索树的中序遍历是有序的
        if (root == null) return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
