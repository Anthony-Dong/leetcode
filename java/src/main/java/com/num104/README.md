# 求二叉树的最大深度和最小深度

#### [LeetCode 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)

#### [LeetCode 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)

我们知道完全二叉树,是可以根据节点数量进行计算出深度的, 但是非完成二叉树呢 , 他就不满足了, 

树结构体

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
```

## 1. 二叉树的最大深度

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

**说明:** 叶子节点是指没有子节点的节点。

```java
/**
 * 最大深度
 *
 * @param root 根节点
 * @return 最大深度
 */
public static int maxDepth(TreeNode root) {
    // 为空直接返回0
    if (root == null) return 0;
    
    // 递归
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    
    // (left <= right) ? left : right 这个就是取最大值Math.man()
    return ((left >= right) ? left : right) + 1;
}
```

首先我画一张图 大家理解一下 , 

![](https://tyut.oss-accelerate.aliyuncs.com/image/2019-12-17/6f79ddd8-ae5f-4c05-bbc9-fd1364dd198e.png?x-oss-process=style/template01)

所以他的意思就是 当我找到一个叶子节点 , 我就+1 (在那个分支上) , 然后返回的时候 , 大的+1 ; 所以我们想想我们计算树的深度是不是这么计算了 从 1->3->4 , 从4开始返回+1 (加一是记录深度), 每次遇到根节点都要比较一下, 取最大值然后再加一 

## 2. 二叉树的最大深度

> ​	最小深度是从**根节点到最近叶子节点(空节点当然不算了)的最短路径上的节点数量**。 **说明:** 叶子节点是指没有子节点的节点。

正常人的思路都是下面这个, 前提是做了前面那道题 , 直接答案反过来么 , 但是我们先往下看

```java
/**
 * 最小深度
 *
 * @param root
 * @return
 */
public static int minDepth(TreeNode root) {
    if (root == null) return 0;
    int left = minDepth(root.left);
    int right = minDepth(root.right);
    // (left <= right) ? left : right 这个就是取最小值Math.min()
    return ((left <= right) ? left : right) + 1;
}
```

下面是程序的基本执行流程

![](https://tyut.oss-accelerate.aliyuncs.com/image/2019-12-17/32311a78-29b5-4e85-9ad1-bf8d2632c87e.png?x-oss-process=style/template01)

看似这个问题和上面那个问题相反 ,但是执行起来还是不好想的, 比如取最短 ,是不是我们拿这个题为例子, 每次遇到根节点都进行比较一下取最小,然后+1 , 其实目的就是为了找到最短的分支 . 

有一种情况比较特殊 : 就是他这里说是 `根节点到最近叶子节点的最短路径` , 所以比如我们上面画的是错的, 因为 null不算是叶子节点, 他为空 ,所以上面那个题叶子节点是4 , 此时树的最小深度是3 ,所以不单单是我们上述题反过来那么简单 ,上述例子出来是1 .



所以正确的代码是 :

```java
/**
 * 最小深度 , 从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * @param root 根节点
 * @return 到最近叶子节点的最短距离
 */
public static int minDepth(TreeNode root) {
    if (root == null) return 0;

    int left = minDepth(root.left);
    int right = minDepth(root.right);
	// 特殊地方
    if (left == 0 || right == 0) return left + right + 1;

    return ((left <= right) ? left : right) + 1;
}
```

执行流程就是下面这个 , 因为`空的叶子节点`不算, 所以我们遇到空叶子节点性需要(不知道是左是右)排除,就是`left + right + 1` ,可能left=0或者right=0 , 两者都等于或者

![](https://tyut.oss-accelerate.aliyuncs.com/image/2019-12-17/5866c9ac-4ac2-4bc3-b9fd-a0a28e897bde.png?x-oss-process=style/template01)

有0则加1 , 无0则取最下+1 ; 