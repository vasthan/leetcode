package com.adc._100_199._148_sort_list;


/*
148. 排序链表
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5
 */

// 使用归并排序
class Solution {
    // 自顶向下归并
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 寻找中点
        // 这里fast初始化为head.next是有讲究的，可以试一下fast初始化为head，会发生什么事（栈溢出）
        // 可以拿三个节点的链表调试一下，会发现当链表只有两个节点时，不会拆分为两个单节点链表，而是一个双节点链表，一个null
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        // 递归排序左右两部分
        head = sortList(head);
        head2 = sortList(head2);

        // 合并
        return merge(head, head2);
    }

    private ListNode merge(ListNode a, ListNode b) {
        // 分别指向两个链表头节点
        ListNode p1 = a, p2 = b;
        // 虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        // 合并操作的指针，新链表的尾节点
        ListNode p = dummyHead;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                ListNode next = p1.next;
                p1.next = null;
                p.next = p1;
                p1 = next;
            } else {
                ListNode next = p2.next;
                p2.next = null;
                p.next = p2;
                p2 = next;
            }
            p = p.next;
        }
        if (p1 != null) p.next = p1;
        if (p2 != null) p.next = p2;
        return dummyHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;

        printListNode(a);
        ListNode a2 = new Solution().sortList(a);
        printListNode(a2);
    }

    private static void printListNode(ListNode head) {
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null) {
                sb.append("->");
            }
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }
}
