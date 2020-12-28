//给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符
//串。如果答案不存在，则返回空字符串。 
//
// 示例 1: 
//
// 
//输入:
//s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//输出: 
//"apple"
// 
//
// 示例 2: 
//
// 
//输入:
//s = "abpcplea", d = ["a","b","c"]
//
//输出: 
//"a"
// 
//
// 说明: 
//
// 
// 所有输入的字符串只包含小写字母。 
// 字典的大小不会超过 1000。 
// 所有输入的字符串长度不会超过 1000。 
// 
// Related Topics 排序 双指针 
// 👍 118 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public String findLongestWord(String s, List<String> d) {
//        int sLen = s.length();
//        if (sLen == 0) return s;
//        int maxLen = 0;
//        String res = "";
//        for (String tmp:
//             d) {
//            int tmpLen = tmp.length();
//            int i = 0, j = 0;
//            boolean flag = true;
//            // 根据tmp遍历s
//            for (i = 0; i < tmpLen && flag == true; i++) {
//                char target = tmp.charAt(i);
//                while (s.charAt(j++) != target) {
//                    if (j > sLen - 1) {
//                        flag = false;
//                        break;
//                    }
//                }
//            }
//            if (i == tmpLen) {
//                if (tmpLen > maxLen || (tmpLen == maxLen && tmp.compareTo(res) < 0)) {
//                    maxLen = tmpLen;
//                    res = tmp;
//                }
//            }
//        }
//        return res;
//    }
//}

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String str = "";
        for (String sstr : d) {
            for (int i = 0, j = 0; i < s.length() && j < sstr.length(); i++) { // 把两个字符串的len都放在这儿作为条件
                if (s.charAt(i) == sstr.charAt(j)) j++;
                if (j == sstr.length()) { // 把 j 放这儿，方便判断是否已经遍历完sstr，并进行后续操作
                    if (sstr.length() > str.length() || (sstr.length() == str.length() && str.compareTo(sstr) > 0))
                        str = sstr;
                }
            }
        }
        return str;

    }
}

//作者：uYGN9I8C6N
//        链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/solution/kan-si-bu-fu-za-qi-shi-zhen-de-bu-fu-za-by-uygn9i8/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//leetcode submit region end(Prohibit modification and deletion)
