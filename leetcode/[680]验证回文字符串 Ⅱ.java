//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 300 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public boolean validPalindrome(String s) {
//        StringBuilder sb = new StringBuilder(s);
//        System.out.println(s.length());
//        System.out.println(s);
//        System.out.println(sb.reverse());
//        if (s.length() == 0) return true;
//        int left = 0, right = s.length() - 1; // 双指针
//        int flag = 0;
//        while (left < right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                ++flag;
//                if (flag >= 2) return false;
//                if (s.charAt(left + 1) == s.charAt(right)) {
//                    ++left;
//                }
//                else if (s.charAt(left) == s.charAt(right - 1)) {
//                    --right;
//                }
//                else return false;
//            }
//            ++left;
//            --right;
//        }
//        return true;
//        // mlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculm
//        // mlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuclm
//        // 这里解决不了递归问题
//    }
//}

class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isValid(s, i + 1, j) || isValid(s, i, j - 1); // 因为有两种可能的情况【难点】
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isValid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

//        作者：fengyuhe-97
//        链接：https://leetcode-cn.com/problems/valid-palindrome-ii/solution/java-shuang-zhi-zhen-fu-yi-ge-zi-ji-cai-mf4ci/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//leetcode submit region end(Prohibit modification and deletion)
