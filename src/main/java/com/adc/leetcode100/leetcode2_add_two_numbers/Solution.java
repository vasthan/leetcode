package com.adc.leetcode100.leetcode2_add_two_numbers;


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        boolean jump = false;

        while (l1 != null || l2 != null || jump) {
            int sum = jump ? 1 : 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            jump = sum >= 10;
            cur.next =new ListNode(sum % 10);
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(5);
        // ListNode a2 = new ListNode(4);
        // ListNode a3 = new ListNode(3);
        // a1.next = a2;
        // a2.next = a3;

        ListNode b1 = new ListNode(5);
        // ListNode b2 = new ListNode(6);
        // ListNode b3 = new ListNode(4);
        // b1.next = b2;
        // b2.next = b3;

        ListNode node = new Solution().addTwoNumbers(a1, b1);
        StringBuilder res = new StringBuilder();
        while (node != null) {
            res.append(node.val);
            if (node.next != null) {
                res.append("-->");
            }
            node = node.next;
        }
        System.out.println(res.toString());
    }
}
