package com.num2;
/**
 * 链表
 *
 * @date:2019/12/9 19:54
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }


    public static ListNode copy(ListNode head) {
        final ListNode ret = new ListNode(0);
        ListNode temp = ret;

        while (head != null) {
            temp.val = head.val;
            head = head.next;
            if (head != null) {
                temp.next = new ListNode(0);
            }
            temp = temp.next;
        }
        return ret;
    }

    /**
     * 输入 [1,2,3] [1,2] - > [2,4,3]
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int curry = 0;
        // 遍历链表二
        ListNode head = l2;

        // 在链表一上修改
        ListNode temp = l1;

        // 当不为空的时候就继续遍历
        while (head != null) {

            // 求和
            int sum = temp.val + head.val;

            // 大于9 进一
            curry = sum > 9 ? 1 : 0;

            //当大于9 需要下一位进一 , 可能出现下一位已经是9了此时,进一 , 9+1>9 , 然后成了10 ,需要循环遍历 , 链表一
            if (curry == 1) {
                if (temp.next == null) {
                    temp.next = new ListNode(curry);
                } else {
                    temp.next.val += curry;
                    if (temp.next.val > 9) {
                        ListNode temp2 = temp.next;
                        while (temp2.val > 9) {
                            temp2.val -= 10;
                            if (temp2.next == null) {
                                temp2.next = new ListNode(0);
                            }
                            temp2.next.val += 1;
                            temp2 = temp2.next;
                        }
                    }
                }
                // 将当前值 减去10
                sum = sum - 10;
            }
            // 设置当前值
            temp.val = sum;

            // 链表二进下一位
            head = head.next;

            // 如果链表二下一个节点不为空,或者链表一下一个节点为空,此时就在链表一的基础上新建一个下一个节点
            if (head != null && temp.next == null) {
                temp.next = new ListNode(0);
            }
            // 链表一进下一位
            temp = temp.next;
        }
        // 返回链表一
        return l1;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode copy = copy(l1);
        System.out.println(copy);

//        ListNode l2 = new ListNode(9);
//        ListNode listNode = addTwoNumbers(l1, l2);
//        System.out.println(listNode);
//
//
//        System.out.println(l1);
    }
}
