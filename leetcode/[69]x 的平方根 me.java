//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 563 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0; // 特殊情况处理
        int left = 1, right = x, mid;
//        long square; // 处理不了2147395599
        int tmp;
        while (left <= right) {
            mid = left + (right - left) / 2;
//            square = mid * mid;
//            if (square == x) return mid;
//            else if (square < x) left = mid + 1;
//            else right = mid - 1;
            tmp = x / mid;
            if (tmp == mid) return mid;
            else if (tmp < mid) right = mid - 1; // 说明x大了，要缩小一些
            else left = mid + 1; // 说明x小了，要调大一些
        }
        return right; // 思考如果只有一个数，应该返回什么。如1，直接返回。如2，应该返回right
    }
}
//leetcode submit region end(Prohibit modification and deletion)
