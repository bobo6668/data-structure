//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻的孩子中，评分高的孩子必须获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 示例 1: 
//
// 输入: [1,0,2]
//输出: 5
//解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2: 
//
// 输入: [1,2,2]
//输出: 4
//解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 317 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        int length = ratings.length; // 记录数组长度，避免反复查询
        if (length == 1) return length; // 特殊情况先处理

        int[] candys = new int[length]; // 糖果分配数组。初值本应该是1，现在暂时都是0，但是不影响，在最后统计糖果数量时考虑即可

        // 从左往右遍历一遍
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1])
                candys[i] = candys[i - 1] + 1; // 第一次遍历比较简单
        }
        // 从右往左遍历一遍
        for (int j = length - 1; j >= 1; j--) {
            if (ratings[j - 1] > ratings[j])
                candys[j - 1] = Math.max(candys[j - 1], candys[j] + 1); // 第二次遍历需要判断一下
        }
        // 统计糖果总数
        int res = length; // 补上所有人的糖果初值为1，则和的初值为length
        for (int i = 0; i < length; i++) {
            res += candys[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
