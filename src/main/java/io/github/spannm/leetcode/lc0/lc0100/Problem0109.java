package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * <a href="https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/">109. Convert Sorted List to Binary
 * Search Tree</a>.
 */
class Problem0109 extends LeetcodeProblem {

    TreeNode sortedListToBST(ListNode _head) {
        if (_head == null) {
            return null;
        } else if (_head.next == null) {
            return new TreeNode(_head.val);
        }

        ListNode slow = _head;
        ListNode fast = _head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode res = new TreeNode(slow.next.val);
        ListNode righthalf = slow.next.next;
        slow.next = null;
        res.left = sortedListToBST(_head);
        res.right = sortedListToBST(righthalf);
        return res;
    }

}
