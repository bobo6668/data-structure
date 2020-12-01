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
    TreeNode head = null;   // 为了返回单向链表的头节点
    TreeNode pre = null;    // 指向当前节点的前一个节点
    public TreeNode convertBiNode(TreeNode root) {
        helper(root);
        return head;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        // 二查搜索树的中序遍历是递增的
        // 在遍历过程中，修改每一个根节点的左右指向，实现原址修改
        // 左
        helper(root.left);
        // 中
        if (pre == null) {      // 前一个节点为空，说明当前是第一个节点
            head = root;        // 1 记录第一个节点作为单链表的表头
            pre = root;         // 3 更新pre指向
        } else {                // 第一个节点之后的节点
            pre.right = root;   // 1 前一个节点的右指针指向当前节点
            pre = root;         // 3 更新pre指向
        }
        root.left = null;       // 2 当前节点root的左孩子设为空
        // 右
        helper(root.right);
    }
}

//作者：zui-weng-jiu-xian
//        链接：https://leetcode-cn.com/problems/binode-lcci/solution/binode100jian-dan-yi-dong-by-zui-weng-jiu-xian/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//leetcode submit region end(Prohibit modification and deletion)
