//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心算法 双指针 
// 👍 405 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String S) {
        int length = S.length();
        List<Integer> res = new ArrayList<>();
        // 特殊情况处理
        if (length < 2) {
            res.add(length);
            return res;
        }
        // 先遍历一遍S，记录每个数字最后一次出现的位置
        int[] pos = new int[26];
        for (int i = 0; i < length; i++) {
            pos[S.charAt(i) - 'a'] = i;
        }
        // 再遍历一遍S，通过end和currentCharEnd判断是否为符合要求的子串，若是则计算子串长度并记录
        int start = 0, end = 0; // 用以记录当前子串的起点、终点
        for (int i = 0; i < length; i++) {
            // 每次遇到一个新的字符，查询该字符最后出现的位置，与end比较大小，取max更新end
            // 这样可以保证end为目前所遇到的所有字符最后出现的位置里最靠后的一个位置
            end = Math.max(pos[S.charAt(i) - 'a'], end);
            // 若当前位置就是end了，说明可以断开了，找到了一个符合要求的子串，记录
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
