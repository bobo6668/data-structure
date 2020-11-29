//给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 ->
// 0 -> 1，那么它表示二进制数 01101，也就是 13 。 
//
// 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。 
//
// 返回这些数字之和。题目数据保证答案是一个 32 位 整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,0,1,0,1,0,1]
//输出：22
//解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：root = [1,1]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 树中的结点数介于 1 和 1000 之间。 
// Node.val 为 0 或 1 。 
// 
// Related Topics 树 
// 👍 81 👎 0


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
    int ans;
    public int sumRootToLeaf(TreeNode root) {
        sumbinary(root, 0);
        return ans;
    }
    // 构造辅助函数，变量cur表示到达当前节点时所记录的十进制数
    public void sumbinary(TreeNode root, int cur){
        if(root == null){
            return;
        }
        // 用一个变量cur维护到达当前节点时所记录的十进制数
        cur = cur * 2 + root.val;
        // 如果该节点是叶子节点，加入答案，结束该轮递归
        if(root.left == null && root.right == null){
            ans += cur;
            return;
        }
        // 如果不是叶子节点，则递归遍历左、右子树
        sumbinary(root.left, cur);
        sumbinary(root.right, cur);
    }
}

//作者：java-man
//        链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/solution/yong-shi-100nei-cun-9517-by-lzx_javaxiao-bai/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//leetcode submit region end(Prohibit modification and deletion)
