package com.keanu.algorithm.leetcode.medium;

import com.keanu.algorithm.leetcode.easy.entity.ListNode;

/**
 * 24 - medium - swap nodes in pairs
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode res = new ListNode(0);
        res.next = node;
        ListNode prev = res;
        while (node != null) {
            ListNode n1 = node;
            ListNode n2 = node.next;
            prev.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            prev = n1;
            node = n1.next;
        }
        return res.next;
    }
}
