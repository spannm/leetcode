package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

class Problem0369 extends LeetcodeProblem {

    ListNode plusOne(ListNode _head) {

        ListNode temp = _head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int[] nums = new int[len];
        temp = _head;
        int j = 0;
        while (temp != null) {
            nums[j++] = temp.val;
            temp = temp.next;
        }

        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] != 9) {
                nums[i]++;
                break;
            } else {
                nums[i] = 0;
            }
        }

        ListNode pre = new ListNode(-1);
        if (nums[0] == 0) {

            ListNode newHead = new ListNode(1);
            ListNode result = newHead;
            int count = 0;
            while (count++ < len) {
                newHead.next = new ListNode(0);
                newHead = newHead.next;
            }
            return result;
        } else {
            pre.next = _head;
            for (int i = 0; i < len; i++) {
                _head.val = nums[i];
                _head = _head.next;
            }
            return pre.next;
        }
    }

}
