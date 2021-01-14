//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 850 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1, target = nums.length - k;
        if (nums.length == 1 && target == 0) return nums[0]; // 特殊情况
        while (left < right) {
            int mid = Helper(nums, left, right); // 利用到了快排的切分操作
//            System.out.println("left = " + left + " right = " + right);
//            System.out.println("mid = " + mid + " target = " + target);
//            System.out.println(Arrays.toString(nums));
            if (mid == target) return nums[mid];
            if (mid < target) left = mid + 1;
            else right = mid - 1;
//            System.out.println("left = " + left + " right = " + right);
        }
        return nums[left]; // 此时left = right
    }
    private int Helper(int[] nums, int left, int right) {
        int value = nums[left]; // 选择的切分元素
        int i = left, j = right; // 两个指针
        while (i < j) {
            while (nums[j] >= value && i < j) j--;
            while (nums[i] <= value && i < j) i++;
            if (i < j) swap(nums, i, j);
        }
        swap(nums, left, i);
        return i;
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
