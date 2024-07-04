package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * <a href="https://leetcode.com/problems/middle-of-the-linked-list/">876. Middle of the Linked List</a>.
 */
class Problem0876 extends LeetcodeProblem {

    ListNode middleNode(ListNode _head) {
        ListNode node = _head;
        int count = 1;
        while ((node = node.next) != null) {
            count++;
        }
        if (count == 1) {
            return _head;
        }

        int middle = count / 2 + 1;

        node = _head;
        count = 1;
        while ((node = node.next) != null) {
            if (++count == middle) {
                break;
            }
        }
        return node;
    }

}
