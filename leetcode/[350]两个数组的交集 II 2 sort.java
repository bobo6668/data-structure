//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 424 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 法2：排序 + 双指针
        // ① 排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // ② 双指针，分别对应两个数组
        int idx1 = 0;
        int idx2 = 0;

        // 暂时以较小规模的数组的大小创建数组res
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        // 指针3，对应数组res
        int idx3 = 0;
        // 遍历两个数组，并把相同元素存到res数组
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] == nums2[idx2]) {
                res[idx3++] = nums1[idx1];
                idx1++;
                idx2++;
            } else if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else {
                idx2++;
            }
        }
        // 拷贝原数组的指定内容，返回一个新的数组
        return Arrays.copyOfRange(res, 0, idx3);
        // copyOfRange(int [] original,int from,int to)
        // original为原始的int型数组，from为开始角标值，to为终止角标值
        // [from, to)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
