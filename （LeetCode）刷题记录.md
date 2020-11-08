# （LeetCode）刷题记录

[toc]

## 0. 方法

> 大家都是如何刷 LeetCode 的？ - 知乎 https://www.zhihu.com/question/280279208

按从低到高的难度分组刷
按 tag 分类刷
定期复习，重做之前刷过的题



## 1. 按 tag 分类刷

### 1.1 栈

* [20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)  2020年11月3日
  * 思路：左括号进栈，右括号出栈，并用switch判断
* [155. 最小栈]()  2020年11月3日
  * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈
  * 思路：多开一个栈来存min
  * Better：省一点空间，只用1个栈 + 1点技巧：[解法2](https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/)
* [225. 用队列实现栈](https://leetcode-cn.com/problems/implement-stack-using-queues/)  2020年11月4日
  * 思路：
    * 队列：先进先出。队头出，队尾进
    * 栈：先进后出。只能从栈顶进、出
    * 所以，进栈容易，出栈比较麻烦。取巧一下：先出队再重新进
* [232. 用栈实现队列](https://leetcode-cn.com/problems/implement-queue-using-stacks/)  2020年11月5日
  * 思路：
    * 两个栈实现先入先出队列
    * [better](https://leetcode-cn.com/problems/implement-queue-using-stacks/solution/shi-yong-liang-ge-zhan-yi-ge-zhuan-men-ru-dui-yi-g/)：一个专门输入，一个专门输出；并用front记住队头变量，可以直接peek()
* [496. 下一个更大元素 I](https://leetcode-cn.com/problems/next-greater-element-i/)  2020年11月5日
  * 思路：
    * [单调栈解决 Next Greater Number 一类问题](https://leetcode-cn.com/problems/next-greater-element-i/solution/dan-diao-zhan-jie-jue-next-greater-number-yi-lei-w/)
    * 用HashMap提高查找效率
* [682. 棒球比赛](https://leetcode-cn.com/problems/baseball-game/)    2020年11月6日
  * 知识点：
    * [java字符串和数字相互转换](https://blog.csdn.net/nuoyuezuo/article/details/85095869?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.add_param_isCf&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.add_param_isCf)
    * [String字符串相等判断](https://blog.csdn.net/java_collect/article/details/102744656?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.add_param_isCf&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.add_param_isCf)
  * 思路：用栈很容易实现，跟后缀表达式求值有点像
* [1021. 删除最外层的括号](https://leetcode-cn.com/problems/remove-outermost-parentheses/)  2020年11月6日
  * 知识点：
    * [StringBuilder](https://www.runoob.com/java/java-stringbuffer.html)
    * [for each](https://www.runoob.com/java/method-for.html)
  * 思路：[Better 不用栈，用在线检测](https://leetcode-cn.com/problems/remove-outermost-parentheses/solution/jian-ji-de-java-shi-xian-by-huaouo/)
* [1047. 删除字符串中的所有相邻重复项](https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/)  2020年11月7日
  * 思路：使用StringBuilder来模拟栈
* [1441. 用栈操作构建数组](https://leetcode-cn.com/problems/build-an-array-with-stack-operations/)  2020年11月7日
  * 知识点：`List<String> list = new ArrayList<>();`
  * 思路：读懂题意即可
* [1544. 整理字符串](https://leetcode-cn.com/problems/make-the-string-great/)  2020年11月8日
  * 知识点：
    * [大小写字母ASCII码之间的关系](https://baike.baidu.com/item/ASCII)：'a' - 'A' = 32, 'a' - 'z' = -25
    * `for (char c : s.toCharArray())`
  * 思路：读懂题意即可
* 



### 1.2 队列

* 



### 1.3 树

* [704. 二分查找](https://leetcode-cn.com/problems/binary-search/)  2020年10月20日
  * 思路：？
* [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)  2020年10月21日
  * 思路：？
* [110. 平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/)  2020年10月22日
  * 思路：？
* [剑指 Offer 27. 二叉树的镜像](https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/)  2020年10月23日
  * 思路：？



### 1.4 堆

* [剑指 Offer 40. 最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)  2020年11月7日
  * 思路：[Better 用大顶堆](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/3chong-jie-fa-miao-sha-topkkuai-pai-dui-er-cha-sou/)
* 

 

### 1.5 排序

* [912. 排序数组](https://leetcode-cn.com/problems/sort-an-array/)  2020年10月30日
  * 思路：写了个快排？