//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 112 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        preoderHelper(root);
        return res;
    }
    private void preoderHelper(Node root) {
        if (root == null) return;
        // 后序遍历：左, ..., 右, 中
        for (Node child : root.children) {
            postorder(child);
        }
        res.add(root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
