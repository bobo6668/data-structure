//给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。 
// Related Topics 二分查找 
// 👍 181 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        // [0 0 1 1 2]
        // 偶 奇 偶 奇 偶
        // [0 0 1 2 2]
        int lo = 0, hi = nums.length - 1, mid;
//        if (hi == lo) return nums[0]; // 特殊情况处理
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (mid % 2 == 1) --mid; // 只考虑偶数位
            if (nums[mid] == nums[mid + 1]) {// 单个元素在左边
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
