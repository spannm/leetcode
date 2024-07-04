package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * 2807. Insert Greatest Common Divisors in Linked List.
 */
class Problem2807 extends LeetcodeProblem {

    ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            int x = gcd(pre.val, cur.val);
            pre.next = new ListNode(x, cur);
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
