//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 616 👎 0

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        // 方法1：哈希表 + 桶排序
        Map<Integer, Integer> counts = new HashMap<>();
        int max_count = 0; // 记录最大频数
        for (int i = 0; i < nums.length; i++) {
            int count = counts.getOrDefault(nums[i], 0) + 1;
            max_count = Math.max(max_count, count);
            counts.put(nums[i], count);
        }
        // 桶排序
        List<Integer>[] buckets = new List[max_count + 1]; // 下标是频数，数值是数字 // 注意new List[] 是没有<>的
        for (int key : counts.keySet()) { // 遍历哈希表
//            buckets[counts.get(key)].add(key); // 有误，还没有初始化(调用构造函数)
            // 获取出现的次数作为下标
            int i = counts.get(key);
            if(buckets[i] == null){
                buckets[i] = new ArrayList();
            }
            buckets[i].add(key);
        }
        int resCount = 0;
        for (int i = max_count; i >= 0 && resCount < k; i--) {
            if (buckets[i] == null) continue; // 注意
            for (int num : buckets[i]) {
                res[resCount++] = num;
                if (resCount == k) break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
