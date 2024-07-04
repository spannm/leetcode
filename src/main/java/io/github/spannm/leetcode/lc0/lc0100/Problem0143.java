package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * <a href="https://leetcode.com/problems/reorder-list/">143. Reorder List</a>.
 */
class Problem0143 extends LeetcodeProblem {

    ListNode reorderList(ListNode _head) {
        if (_head == null || _head.next == null) {
            return _head;
        }
        // use two pointers to separate given list into two parts
        ListNode slowNode = _head;
        ListNode fastNode = _head;
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            if (fastNode.next != null) {
                fastNode = fastNode.next;
            } else {
                break;
            }
            slowNode = slowNode.next;
        }

        ListNode head1 = _head;
        ListNode head2 = slowNode.next;
        slowNode.next = null;

        ListNode cur = head2;
        ListNode post = cur.next;
        cur.next = null;
        while (post != null) {
            ListNode temp = post.next;
            post.next = cur;
            cur = post;
            post = temp;
        }
        head2 = cur;

        ListNode p = head1;
        ListNode q = head2;
        while (q != null) {
            ListNode temp1 = p.next;
            ListNode temp2 = q.next;
            p.next = q;
            q.next = temp1;
            p = temp1;
            q = temp2;
        }
        return _head;
    }

}
