# （LeetCode）刷题记录

[toc]

## 0. 方法

> 大家都是如何刷 LeetCode 的？ - 知乎 https://www.zhihu.com/question/280279208

* 按从低到高的难度分组刷
* 按 tag 分类刷
* 定期复习，重做之前刷过的题



## 1. 按 tag 分类刷

### 1.1 栈

| 题目                                                         | 时间+代码     | 思路                                                         | 知识点                                                       |
| ------------------------------------------------------------ | ------------- | ------------------------------------------------------------ | :----------------------------------------------------------- |
| [20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/) | 2020年11月3日 | 左括号进栈，右括号出栈，并用switch判断                       |                                                              |
| [155. 最小栈]()                                              | 2020年11月3日 | 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈 |                                                              |
|                                                              |               | 法1：多开一个栈来存min                                       |                                                              |
|                                                              |               | 法2：[Better 解法2](https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/) 省一点空间，只用1个栈 + 1点技巧 |                                                              |
| [225. 用队列实现栈](https://leetcode-cn.com/problems/implement-stack-using-queues/) | 2020年11月4日 | 取巧一下：先出队再重新进                                     | ① 队列：先进先出。队头出，队尾进                             |
|                                                              |               |                                                              | ② 栈：先进后出。只能从栈顶进、出                             |
|                                                              |               |                                                              | ③ 所以，进栈容易，出栈比较麻烦。                             |
| [232. 用栈实现队列](https://leetcode-cn.com/problems/implement-queue-using-stacks/) | 2020年11月5日 | 法1：两个栈实现先入先出队列                                  |                                                              |
|                                                              |               | 法2：[better](https://leetcode-cn.com/problems/implement-queue-using-stacks/solution/shi-yong-liang-ge-zhan-yi-ge-zhuan-men-ru-dui-yi-g/) 一个专门输入，一个专门输出；并用front记住队头变量，可以直接peek() |                                                              |
| [496. 下一个更大元素 I](https://leetcode-cn.com/problems/next-greater-element-i/) | 2020年11月5日 | [单调栈解决 Next Greater Number 一类问题](https://leetcode-cn.com/problems/next-greater-element-i/solution/dan-diao-zhan-jie-jue-next-greater-number-yi-lei-w/) | 用HashMap提高查找效率                                        |
| [682. 棒球比赛](https://leetcode-cn.com/problems/baseball-game/) | 2020年11月6日 | 用栈很容易实现，跟后缀表达式求值有点像                       | [java字符串和数字相互转换](https://blog.csdn.net/nuoyuezuo/article/details/85095869?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.add_param_isCf&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.add_param_isCf) |
|                                                              |               |                                                              | [String字符串相等判断](https://blog.csdn.net/java_collect/article/details/102744656?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.add_param_isCf&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.add_param_isCf) |
| [1021. 删除最外层的括号](https://leetcode-cn.com/problems/remove-outermost-parentheses/) | 2020年11月6日 | [Better 不用栈，用在线检测](https://leetcode-cn.com/problems/remove-outermost-parentheses/solution/jian-ji-de-java-shi-xian-by-huaouo/) | [for each](https://www.runoob.com/java/method-for.html)      |
| [1047. 删除字符串中的所有相邻重复项](https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/) | 2020年11月7日 | 使用StringBuilder来模拟栈                                    | [StringBuilder](https://www.runoob.com/java/java-stringbuffer.html) |
| [1441. 用栈操作构建数组](https://leetcode-cn.com/problems/build-an-array-with-stack-operations/) | 2020年11月7日 | 读懂题意即可                                                 | `List<String> list = new ArrayList<>();`                     |
| [1544. 整理字符串](https://leetcode-cn.com/problems/make-the-string-great/) | 2020年11月8日 | 读懂题意即可                                                 | [大小写字母ASCII码之间的关系](https://baike.baidu.com/item/ASCII)：'a' - 'A' = 32, 'a' - 'z' = -25 |
|                                                              |               |                                                              | `for (char c : s.toCharArray())`                             |
| [1598. 文件夹操作日志搜集器](https://leetcode-cn.com/problems/crawler-log-folder/) | 2020年11月8日 | 法1：栈，空间复杂度O(n)                                      |                                                              |
|                                                              |               | 法2：受到法1过程的启发，不需要用栈，空间复杂度O(1)           |                                                              |
|                                                              |               |                                                              |                                                              |



### 1.2 队列

| 题目                                                         | 时间+代码     | 思路                                                         | 知识点                                       |
| ------------------------------------------------------------ | ------------- | ------------------------------------------------------------ | :------------------------------------------- |
| [933. 最近的请求次数](https://leetcode-cn.com/problems/number-of-recent-calls/) | 2020年11月9日 | 超过范围的出队即可                                           | `Queue<Integer> queue = new LinkedList<>();` |
| [剑指 Offer 59 - I. 滑动窗口的最大值](https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/) | 2020年11月9日 | [单调队列](https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-i-hua-dong-chuang-kou-de-zui-da-1-6/) | 单调队列是一个双端队列                       |
|                                                              |               |                                                              |                                              |



### 1.3 树

| 题目                                                         | 时间+代码                                                    | 思路                                                         | 知识点                                                       |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | :----------------------------------------------------------- |
| [704. 二分查找](https://leetcode-cn.com/problems/binary-search/) | 2020年10月20日                                               | ？                                                           |                                                              |
| [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/) | 2020年10月21日                                               | ？                                                           |                                                              |
|                                                              |                                                              |                                                              |                                                              |
| [剑指 Offer 27. 二叉树的镜像](https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/) | 2020年10月23日                                               | ？                                                           |                                                              |
| [100. 相同的树](https://leetcode-cn.com/problems/same-tree/) | 2020年11月14日                                               | 递归                                                         |                                                              |
| [101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/) | 2020年11月14日                                               | [递归](https://leetcode-cn.com/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/) | 找到对称的规律：① 左的左 = 右的右 ② 左的右 = 右的左          |
| [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/) | 2020年11月15日                                               | 递归                                                         | 树的深度 = max {左子树深度, 右子树深度} + 1                  |
| [102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/) | 2020年11月15日                                               | [广度优先](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/)需要用队列作为辅助结构。先将根节点放到队列中，然后不断遍历队列 | [广度优先搜索算法（Breadth-First-Search）](https://www.jianshu.com/p/b086986969e6) |
| [107. 二叉树的层次遍历 II](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/) | 2020年11月16日                                               | 在上一题的基础上简单修改即可。主要是逆序输出。               | `res.add(0,tmp); //为了逆序输出，采用链表，并添加到头部`     |
| [108. 将有序数组转换为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/) | 2020年11月16日                                               | 讲解：[构造二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/tu-jie-er-cha-sou-suo-shu-gou-zao-di-gui-python-go/)。[代码](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jian-dan-di-gui-bi-xu-miao-dong-by-sweetiee/) | 二查搜索树、树的构造、中序遍历                               |
| [110. 平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/) | 2020年10月22日，[2020年11月19日](https://github.com/bobo6668/data-structure/blob/master/leetcode/%5B110%5D%E5%B9%B3%E8%A1%A1%E4%BA%8C%E5%8F%89%E6%A0%91.java) | 需要遍历所有节点：根、左、右                                 | 先序遍历（递归）、树的高度（递归）                           |
| [111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/) | [2020年11月19日](https://github.com/bobo6668/data-structure/blob/master/leetcode/%5B111%5D%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E5%B0%8F%E6%B7%B1%E5%BA%A6.java) | [理解递归结束条件](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/li-jie-zhe-dao-ti-de-jie-shu-tiao-jian-by-user7208/) |                                                              |
| [112. 路径总和](https://leetcode-cn.com/problems/path-sum/)  | [2020年11月20日](https://github.com/bobo6668/data-structure/blob/master/leetcode/%5B112%5D%E8%B7%AF%E5%BE%84%E6%80%BB%E5%92%8C.java) | 不需要知道具体路径：[DFS 深度优先搜索](https://leetcode-cn.com/problems/path-sum/solution/lu-jing-zong-he-de-si-chong-jie-fa-dfs-hui-su-bfs-/) |                                                              |
|                                                              | [2020年11月21日](https://github.com/bobo6668/data-structure/blob/master/leetcode/%5B112%5D%E8%B7%AF%E5%BE%84%E6%80%BB%E5%92%8C%20change.java) | 若需要知道具体路径：稍改一下代码，加一个List记录每个节点的值 |                                                              |
| [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/) | [2020年11月21日](https://github.com/bobo6668/data-structure/blob/master/leetcode/%5B226%5D%E7%BF%BB%E8%BD%AC%E4%BA%8C%E5%8F%89%E6%A0%91.java) | 读懂题意即可                                                 |                                                              |
| [235. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) | [2020年11月21日](https://github.com/bobo6668/data-structure/blob/master/leetcode/%5B235%5D%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88.java) | [利用二叉搜索树的特点，递归](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/di-gui-he-die-dai-fa-by-hyj8/) |                                                              |
| [257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/) | [2020年11月22日](https://github.com/bobo6668/data-structure/blob/master/leetcode/%5B257%5D%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%89%80%E6%9C%89%E8%B7%AF%E5%BE%84.java) | [构造辅助函数：基于深度搜索。并利用好传入参数](https://leetcode-cn.com/problems/binary-tree-paths/solution/257-er-cha-shu-de-suo-you-lu-jing-tu-wen-jie-xi-by/) |                                                              |
|                                                              |                                                              |                                                              |                                                              |



### 1.4 堆

| 题目                                                         | 时间+代码     | 思路                                                         | 知识点                                                       |
| ------------------------------------------------------------ | ------------- | ------------------------------------------------------------ | :----------------------------------------------------------- |
| [剑指 Offer 40. 最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/) | 2020年11月7日 | [Better 用大根堆](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/3chong-jie-fa-miao-sha-topkkuai-pai-dui-er-cha-sou/) | `PriorityQueue` 默认是小根堆，实现大根堆需要重写一下比较器   |
|                                                              |               |                                                              | `Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);` |
|                                                              |               |                                                              |                                                              |

 

### 1.5 排序

| 题目                                                         | 时间+代码      | 思路         | 知识点 |
| ------------------------------------------------------------ | -------------- | ------------ | :----- |
| [912. 排序数组](https://leetcode-cn.com/problems/sort-an-array/) | 2020年10月30日 | 写了个快排？ |        |

