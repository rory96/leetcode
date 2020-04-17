package com.keanu.algorithm.leetcode.easy;

import com.keanu.algorithm.leetcode.easy.entity.ListNode;

/**
 * 206 - easy - 反转链表
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode current = head.next;
        head.next = null;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = head;
            head = current;
            current = next;
        }
        return head;
    }
}
