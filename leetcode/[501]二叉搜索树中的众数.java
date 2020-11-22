//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 242 👎 0


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
    // 二查搜索树的中序遍历是一个有序的数组
    // 为了统计出现的频次，需要知道当前值是否跟上一次的值一致
    // 当前频次count, 最大的频次maxCount
    TreeNode pre; // 记录上一个节点
    int count;
    int maxCount;
    List<Integer> res;

    public Solution() {
        pre = null;
        count = 0;
        maxCount = 0;
        res = new ArrayList<Integer>();
    }
    public int[] findMode(TreeNode root) { // 主函数
        findModeHelper(root); // 调用辅助函数
        // 把 ArrayList<Interger> 转成 int[]，才可以返回
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
    private void findModeHelper(TreeNode root) { // 辅助函数
        if (root == null) return;
        // 左
        findModeHelper(root.left);
        // 根
        if (pre == null) count = 1;
        else if (root.val == pre.val) count++;
        else if (root.val != pre.val) count = 1;
        pre = root; // 更新pre
        if (count > maxCount) {
            res.clear();
            res.add(root.val);
            maxCount = count;
        }
        else if (count == maxCount) {
            res.add(root.val);
        }
        // 右
        findModeHelper(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
