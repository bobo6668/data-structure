//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 统计数组arr1中各个元素的个数
        int maxValue = 1000 + 1;
        int[] count = new int[maxValue]; // count的下标表示元素的值，count的值表示该元素的数量
        for (int num:
             arr1) {
            count[num]++;
        }
        // 按照arr2的元素顺序来重新生成数组
        int idx = 0;
        for (int num:
             arr2) {
            while(count[num] > 0) {
                arr1[idx] = num;
                count[num]--;
                idx++;
            }
        }
        // 将arr1在arr2中没出现的元素依次放在新arr1的尾部
        for (int i = 0; i < maxValue; i++) {
            while (count[i] > 0) {
                arr1[idx] = i;
                count[i]--;
                idx++;
            }
        }
        // 返回新的arr1
        return arr1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
