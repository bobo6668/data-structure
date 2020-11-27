//如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。 
//
// 只有给定的树是单值二叉树时，才返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[1,1,1,1,1,null,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 输入：[2,2,2,5,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定树的节点数范围是 [1, 100]。 
// 每个节点的值都是整数，范围为 [0, 99] 。 
// 
// Related Topics 树 
// 👍 67 👎 0


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
    public boolean isUnivalTree(TreeNode root) {
        // 若root为空，返回true，这样后面递归才方便【√】
        if (root == null) return true;
        // 到这里，说明root不为空
        // 若左儿子不为空，则看是否相等
        if (root.left != null && root.val != root.left.val) return false;
        // 若右儿子不为空，则看是否相等
        if(root.right != null && root.val != root.right.val) return false;
        // 递归，注意是&&
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
//作者：KA51VzMd7A
//        链接：https://leetcode-cn.com/problems/univalued-binary-tree/solution/qian-xu-bian-li-di-gui-qiu-jie-by-ka51vzmd7a/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//leetcode submit region end(Prohibit modification and deletion)
