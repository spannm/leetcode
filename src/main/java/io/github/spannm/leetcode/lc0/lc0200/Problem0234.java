package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

class Problem0234 extends LeetcodeProblem {

    boolean isPalindrome(ListNode _head) {
        ListNode slow = _head;
        ListNode fast = _head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode half2Head = reverse(slow.next);
        ListNode half1Head = _head;
        while (half1Head != null && half2Head != null) {
            if (half1Head.val != half2Head.val) {
                return false;
            }
            half1Head = half1Head.next;
            half2Head = half2Head.next;
        }
        return true;
    }

    static ListNode reverse(ListNode _head) {
        ListNode newHead = null;
        while (_head != null) {
            ListNode next = _head.next;
            _head.next = newHead;
            newHead = _head;
            _head = next;
        }
        return newHead;
    }

}
