//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 特殊情况处理
        int length = nums.length;
        if (length == 0) return new int[] {-1, -1};
        // 分别找到第一次和最后一次
        int left = helperLeft(nums, target);
        int right = helperRight(nums, target);
        // 特殊情况处理【】
        if (left == length || nums[left] != target) return new int[] {-1, -1}; // 【debug】注意第二个判断
        return new int[] {left, right};
    }
    private int helperLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] >= target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1;
        }
        return l;
        // 如果是{1},找1,最终l=0,r=-1,则返回l;
        // 如果是{2},找1,最终l=1,r=0,则返回l;
        // 如果是{1,1,1},找1,最终l=0,r=-1,则返回l;
        // 如果是{0,1,1},找1,最终l=1,r=0,则返回l;
        // 如果是{0,0,1},找1,最终l=1,r=0,则返回l;
    }
    private int helperRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] <= target) l = mid + 1;
        }
        return r;
        // 如果是{1},找1,最终l=1,r=0,则返回r;
        // 如果是{2},找1,最终l=0,r=-1,则返回r;
        // 如果是{1,1,1},找1,最终l=3,r=2,则返回r;
        // 如果是{0,1,1},找1,最终l=3,r=2,则返回l;
        // 如果是{0,0,1},找1,最终l=3,r=2,则返回r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
