package com.keanu.algorithm.leetcode.easy;

import com.keanu.algorithm.leetcode.easy.entity.ListNode;

/**
 * 206 - easy - 反转链表
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode tmp, res;
        res = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            tmp = new ListNode(head.val);
            tmp.next = res;
            res = tmp;
            head = head.next;
        }
        return res;
    }
}
