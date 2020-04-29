package com.keanu.algorithm.leetcode.easy;

import com.keanu.algorithm.leetcode.easy.entity.ListNode;

/**
 * 141 - easy - 环形链表
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
