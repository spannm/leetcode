package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * 2674. Split a Circular Linked List.
 */
class Problem2674 extends LeetcodeProblem {

    ListNode[] splitCircularLinkedList(ListNode list) {
        ListNode a = list;
        ListNode b = list;
        while (b.next != list && b.next.next != list) {
            a = a.next;
            b = b.next.next;
        }
        if (b.next != list) {
            b = b.next;
        }
        ListNode list2 = a.next;
        b.next = list2;
        a.next = list;
        return new ListNode[] {list, list2};
    }

}
