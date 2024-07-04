package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

class Problem0160 extends LeetcodeProblem {

    ListNode getIntersectionNode(ListNode _headA, ListNode _headB) {
        int lenA = calcLen(_headA);
        int lenB = calcLen(_headB);
        while (lenA < lenB) {
            _headB = _headB.next;
            lenB--;
        }

        while (lenB < lenA) {
            _headA = _headA.next;
            lenA--;
        }

        while (_headA != _headB) {
            _headA = _headA.next;
            _headB = _headB.next;
        }

        return _headA;
    }

    private static int calcLen(ListNode _head) {
        int len = 0;
        while (_head != null) {
            _head = _head.next;
            len++;
        }
        return len;
    }

}
