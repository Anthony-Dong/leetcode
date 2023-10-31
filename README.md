# LeetCode  解题之路

> ​	首先申明. 可以跟着我的题号走.  但是我下面这个文档题目并不全,只是前期加上去的, 前期节奏慢可以做这些,  后期懒得加上去了. 我做的题目都是经典题目, 基本都包含吧. 
>
> ​	可以浏览一下目录, 点进去感兴趣的 , 看看我的个人理解吧. 我觉得我理解的比较简单, 也挺容易懂的. 别把算法定义的太高级的概念吓跑了. 其实学习算法对于编程的提升很大的. 
>
> ​	其次推荐一下 , 极客时间的算法40讲, 带你了解算法, 课程应该正常人可以一周到一个月完成, 看你的算法底子. 

## 1. 链表部分

### 1. LeetCode - 2 [两数相加](https://leetcode-cn.com/problems/add-two-numbers/)

 [源码位置](./Java/src/main/java/com/num2) , [讲解](./Java/src/main/java/com/num2/README.md)


### 2. LeetCode - 19 [删除链表的倒数第N个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)

 [源码位置](./Java/src/main/java/com/num19) , [讲解](./Java/src/main/java/com/num19/README.md)


### 3. LeetCode -  92 [反转链表 II](https://leetcode-cn.com/problems/reverse-linked-list-ii/)

 [源码位置](./Java/src/main/java/com/num92) ,[讲解](./Java/src/main/java/com/num92/README.md)



其实链表吧 . 比较难的就是单链表操作. 双链表的话,一般不考.  单链表的N个旋转.  

### 链表部分

206 代码

链表全局反转, 

链表局部反转

链表判断是否有无环.  loop / circle

## 树 

其实核心就是遍历.  理解DFS和BFS . (递归+非递归)

进阶篇 , 就是理解了 DFS后, 进行的一些学习吧. 核心是DFS思想这块. 

高级篇 , 就是树的变种, 可能是 BSF , B+ ,红黑. 基本就是这操作吧. 

**当你真正掌握了树的操作和思想. 递归代码解决问题 对你来说太简单了, ** 

## 队列/ 栈

括号问题, 匹配括号  , num20 . 

灵活使用队列和栈. 

## 堆

二叉堆.  就是我们最简单的那种实现. 依靠数组实现的. 但是再次插入一个元素时, 就是heapfiy时 就会出现问题.  效率低.

这是维基百科打的Heap中告诉的几种方式. 

|                          Operation                           |   find-min   |                          delete-min                          |                            insert                            |                         decrease-key                         |                             meld                             |
| :----------------------------------------------------------: | :----------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
| [Binary](https://en.wikipedia.org/wiki/Binary_heap)[[8\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-CLRS-9) |    *Θ*(1)    |                         *Θ*(log *n*)                         |                         *O*(log *n*)                         |                         *O*(log *n*)                         |                           *Θ*(*n*)                           |
|    [Leftist](https://en.wikipedia.org/wiki/Leftist_tree)     |    *Θ*(1)    |                         *Θ*(log *n*)                         |                         *Θ*(log *n*)                         |                         *O*(log *n*)                         |                         *Θ*(log *n*)                         |
| [Binomial](https://en.wikipedia.org/wiki/Binomial_heap)[[8\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-CLRS-9)[[9\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-10) |    *Θ*(1)    |                         *Θ*(log *n*)                         | *Θ*(1)[[b\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-amortized-11) |                         *Θ*(log *n*)                         | *O*(log *n*)[[c\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-meld-12) |
| [Fibonacci](https://en.wikipedia.org/wiki/Fibonacci_heap)[[8\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-CLRS-9)[[10\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-Fredman_And_Tarjan-13) |    *Θ*(1)    | *O*(log *n*)[[b\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-amortized-11) |                            *Θ*(1)                            | *Θ*(1)[[b\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-amortized-11) |                            *Θ*(1)                            |
| [Pairing](https://en.wikipedia.org/wiki/Pairing_heap)[[11\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-Iacono-14) |    *Θ*(1)    | *O*(log *n*)[[b\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-amortized-11) |                            *Θ*(1)                            | *o*(log *n*)[[b\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-amortized-11)[[d\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-pairingdecreasekey-17) |                            *Θ*(1)                            |
| [Brodal](https://en.wikipedia.org/wiki/Brodal_queue)[[14\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-18)[[e\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-brodal-20) |    *Θ*(1)    |                         *O*(log *n*)                         |                            *Θ*(1)                            |                            *Θ*(1)                            |                            *Θ*(1)                            |
| [Rank-pairing](https://en.wikipedia.org/w/index.php?title=Rank-pairing_heap&action=edit&redlink=1)[[16\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-21) |    *Θ*(1)    | *O*(log *n*)[[b\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-amortized-11) |                            *Θ*(1)                            | *Θ*(1)[[b\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-amortized-11) |                            *Θ*(1)                            |
| [Strict Fibonacci](https://en.wikipedia.org/wiki/Fibonacci_heap)[[17\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-22) |    *Θ*(1)    |                         *O*(log *n*)                         |                            *Θ*(1)                            |                            *Θ*(1)                            |                            *Θ*(1)                            |
| [2-3 heap](https://en.wikipedia.org/wiki/2-3_heap)[[18\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-23) | *O*(log *n*) | *O*(log *n*)[[b\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-amortized-11) | *O*(log *n*)[[b\]](https://en.wikipedia.org/wiki/Heap_(data_structure)#cite_note-amortized-11) |                            *Θ*(1)                            |                             *?*                              |

效率最高的是 严格的斐波那契堆. 



## 2. 中位数

> ​	中位值都很难啊
### 1. LeetCode - 4 [寻找两个有序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)

 [源码位置](./Java/src/main/java/com/num4) , [讲解](./Java/src/main/java/com/num4/README.md)



## 3. 字符串
>   其实字符串类似于数组, 把他想成数组就行了
>   回文字符串就有一点复杂
>
>   ### 1. LeetCode - 3  [无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

 [源码位置](./Java/src/main/java/com/num3) , [讲解](./Java/src/main/java/com/num3/README.md)

### 2. LeetCode - 5 [最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)

 [源码位置](./Java/src/main/java/com/num5) , [讲解](./Java/src/main/java/com/num5/README.md)   

## 4. 数组
>   大多数数组问题,如果是基于子序列问题, 我们可以用滑动窗口算法

### 1. LeetCode - 1 [两数之和](https://leetcode-cn.com/problems/two-sum/)

 [源码位置](./Java/src/main/java/com/num1) , [讲解](./Java/src/main/java/com/num1/README.md)

### 2. LeetCode - 152 [乘积最大子序列](https://leetcode-cn.com/problems/maximum-product-subarray/)

 [源码位置](./Java/src/main/java/com/num152) , [讲解](./Java/src/main/java/com/num152/README.md)

### 2. LeetCode - 53 [最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)

 [源码位置](./Java/src/main/java/com/num53) , [讲解](./Java/src/main/java/com/num53/README.md) 


## 5. 10进制转其他进制换问题 (巧)

### 1. LeetCode - 168 [Excel表列名称](https://leetcode-cn.com/problems/excel-sheet-column-title)    
 [源码位置](./Java/src/main/java/com/num168) , [讲解](./Java/src/main/java/com/num168/README.md)


## 5. 多线程

### 1. LeetCode - 1195 [交替打印字符串](https://leetcode-cn.com/problems/fizz-buzz-multithreaded/)

 [源码位置](./Java/src/main/java/com/num1195) , [讲解](./Java/src/main/java/com/num1195/README.md)


## 6. 回溯法

### 1. LeetCode - 46 [全排序](https://leetcode-cn.com/problems/permutations)
[源码位置](./Java/src/main/java/com/num46) , [讲解](./Java/src/main/java/com/num46/README.md)

## 7. 排序算法
### 1. [排序算法]()
[源码位置](./Java/src/main/java/com/sort) , [讲解](./Java/src/main/java/com/sort/README.md)

## 7. 递归思想 (DFS)

> ​		其实就是DFS思想.  深度遍历. 其实也好想.  比如深度遍历, 特别适合 层级操作. 都做的是一样的事情. 比如我们树的遍历. 每一层其实都是一样的做法.这种适合用 递归. 

### 1. [递归思想]()
[源码位置](./Java/src/main/java/com/recursive) , [讲解](./Java/src/main/java/com/recursive/README.md)



## 8. 二分思想  和 分治 / 归并

其实就是 logN的秘诀.  二分特别适合查找 , 找到符合的最小单元. 而二分最后分到什么程度可以我们自己控制. 一般就是分到最小. 也就是 4个数字的数组话, 切2次. 就行了. 也就是 log4 .  

**一般说到 " 有序数组 ", 第一个想到的就是二分的思想, 切记 , 这个是必须知道的.** 



所以二分的思想也很重要.  这么说其实类似于 分治的思想. 但是二分一般是分治 . 但是他不包含归并过程. 



分治 / 归并. 比如求Math.pow() . 就是一个分治/归并思想.  子情况都是一样的 . 然后归并过程自己实现. 还有就是我们的归并排序. 

## 9. DP (动态规划)思想. 

动态规划思想 , 其实就是动态递推,找规律就好了.. 主要是解决了重复使用的问题 , 比如说.  斐波那契数组. 我们如果使用递归写法的话, 那么需要重复计算很多项, 那么如何优化呢, 就是DP的思想了 . 



DP 的流程一般是 , 大佬级别是逆推的过程. 因为DP, 需要知道终点.

DP 主要是推那个DP表达式. 就是 F(N)=F(N+1)+F(N+2) 类似于这个

还有就是正常逻辑一般是从开始往结果推.  但是DP一般是倒着推. 

具体可以看看 ,  leetcode 的 64题. 就是一个DP的思想. 其实一般人会想到DFS.



这里可能还有贪心算法之类de.  可以去lc找. 

## 10 . 回溯思想

主要是泛举的思想. 比如` 1,2,3,4` 排列组合问题 . 或者 树型结构思想吧. 

其实比DFS多了, 一个记忆化的思想. 懂了吧. 他会保存这个阶段的状态.  比如这个阶段结束的时候, 要重置当前阶段的状态. 

主要常见的算法 就是,  N皇后的问题 和 一个 子串排列组合的问题吧. 其实怎么说. 还好. 



## 总结 

反正 我这个lc练习的题目吧. 并没有全部展示出来.  我个人习惯不好.  主要是有些题目, 后面写了. 其实发现很简单的.  解题过程和这个都懒得总结了



如果想练习的话. 可以跟着我 的练习题目走. 基本都是常见的题. 高频题目吧 . 反正就是这个了. 

num+(leetcode题号)  , 每一个目录都是. 可以跟着练习. 