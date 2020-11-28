//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 108 👎 0


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
    public boolean isCousins(TreeNode root, int x, int y) {
        //这两个值任意一个都不会出现在根节点
        if (root == null || root.val == x || root.val == y)
            return false;
        // 层序遍历：用队列辅助 【√】注意理解题意，根节点是深度为0，其儿子深度为1，依次类推，所以要层序遍历。区分深度和高度……
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        //对应x值的结点
        TreeNode xNode = null;
        //对应y值的结点
        TreeNode yNode = null;
        //对应x值的父亲的结点
        TreeNode xFather = null;
        //对应y值的父亲的结点
        TreeNode yFather = null;
        //开始bfs
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) { // 遍历属于该层的节点
                TreeNode temp = q.poll(); // 出队，然后处理其左右儿子
                if (temp.left != null) { // 如果左儿子不为空
                    q.add(temp.left);
                    //找节点
                    if (temp.left.val == x) {
                        xNode = temp.left;
                        xFather = temp;
                    }
                    if (temp.left.val == y) {
                        yNode = temp.left;
                        yFather = temp;
                    }
                }
                if (temp.right != null) { // 如果右儿子不为空
                    q.add(temp.right);
                    //找节点
                    if (temp.right.val == x) {
                        xNode = temp.right;
                        xFather = temp;
                    }
                    if (temp.right.val == y) {
                        yNode = temp.right;
                        yFather = temp;
                    }
                }
                // 【√】判断
                //两个节点都没找到，什么也不做
                if (xNode == null && yNode == null) {
                }
                //两个节点都找到了，那么判断它们是不是堂兄弟节点
                else if (xNode != null && yNode != null) {
                    //如果父亲结点不相等，说明是堂兄弟结点
                    return xFather != yFather;
                }
                //这层遍历完了，但是有一个节点找到了，另外一个没找到
                else if (size == 0)
                    return false;
            }
        }
        return false;
    }
}

//作者：sagittarius-l
//        链接：https://leetcode-cn.com/problems/cousins-in-binary-tree/solution/bfsjie-jin-shuang-bai-by-sagittarius-l/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//leetcode submit region end(Prohibit modification and deletion)
