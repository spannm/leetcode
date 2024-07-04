package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

class Problem0328 extends LeetcodeProblem {

    ListNode oddEvenList(ListNode _head) {
        if (_head != null) {
            ListNode odd = _head;
            ListNode even = _head.next;
            ListNode evenHead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }

            odd.next = evenHead;
        }
        return _head;
    }

}
