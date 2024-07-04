package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">19. Remove Nth Node From End of List</a>.
 */
class Problem0019 extends LeetcodeProblem {

    ListNode removeNthFromEnd(ListNode _head, int _n) {
        ListNode node = _head;

        int count = 1;
        while ((node = node.next) != null) {
            count++;
        }

        if (count == 1) {
            if (_n == 1) {
                return null;
            }
            return _head;
        }

        int position = count - _n + 1; // position to remove
        if (position == 1) {
            _head = _head.next;
            return _head;
        }

        node = _head;
        count = 1;
        do {
            if (count == position - 1) {
                // at position before node to be removed
                ListNode before = node;
                ListNode remove = before.next;
                ListNode after = remove.next;
                before.next = after;
                remove.next = null;
                break;
            }
            count++;
        } while ((node = node.next) != null);

        return _head;
    }

    static int getLength(ListNode _head) {
        int count = 1;
        while ((_head = _head.next) != null) {
            count++;
        }
        return count;
    }

}
