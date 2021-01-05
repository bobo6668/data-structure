//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 注意数组中可能存在重复的元素。 
//
// 示例 1： 
//
// 输入: [1,3,5]
//输出: 1 
//
// 示例 2： 
//
// 输入: [2,2,2,0,1]
//输出: 0 
//
// 说明： 
//
// 
// 这道题是 寻找旋转排序数组中的最小值 的延伸题目。 
// 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 218 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 旋转排序数组 nums 可以被拆分为 2 个排序数组 nums1 (左边), nums2 (右边) 【√】
    // 并且 nums1 任一元素 >= nums2 任一元素 【√】
    // 因此，考虑二分法寻找此两数组的分界点 nums[i] (即第 2 个数组的首个元素)
    public int findMin(int[] nums) {
        if (nums.length == 1) { // 特殊情况处理
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        while (left < right) { // 注意这里用不等号
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) // 右边无序，分界点一定在右边
                left = mid + 1;
            else if (nums[mid] < nums[right]) // 右边有序，分界点一定不在右边
                right = mid;
            else  // 无法判断右边是否有序
                right = right - 1;
        }
        return nums[left];
    }
}

//作者：jyd
//        链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/154-find-minimum-in-rotated-sorted-array-ii-by-jyd/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//leetcode submit region end(Prohibit modification and deletion)
