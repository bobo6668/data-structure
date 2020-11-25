//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 
// 👍 215 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Queue;

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        // 层序遍历
        // 用一个队列辅助记录该层次的所有节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
//            long sum = 0; // long 数据类型是 64 位、有符号的以二进制补码表示的整数 [防止溢出] // 效率不高，耗时是double的两倍
            double sum = 0.0; // double 数据类型是双精度、64 位、符合IEEE 754标准的浮点数；也是Java的默认浮点数类型
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.remove();
                sum += tmp.val;
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
//            res.add(1.0 * sum / size);
            res.add(sum / size);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
