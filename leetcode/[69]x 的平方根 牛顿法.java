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
        // 方法2：牛顿法
        // xn+1 = xn − f(xn)/f′(xn)
        // 给定f(x) = x^2 − a = 0，这里的迭代公式为 xn+1 = (xn + a/xn) / 2
        // 这里输入是 x，即 a = x
        long res = x; // 为了防止 int 超上界，我们使用 long 来存储乘法结果 // 初值很重要
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int) res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
