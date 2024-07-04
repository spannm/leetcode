package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

class Problem1019 extends LeetcodeProblem {

    int[] nextLargerNodes(ListNode _head) {
        int len = findLength(_head);
        int[] result = new int[len];
        ListNode tmp = _head;
        int i = 0;
        while (tmp != null) {
            result[i++] = findNextLarger(tmp.val, tmp);
            tmp = tmp.next;
        }
        return result;
    }

    static int findNextLarger(int _val, ListNode _head) {
        ListNode tmp = _head.next;
        while (tmp != null) {
            if (tmp.val > _val) {
                return tmp.val;
            }
            tmp = tmp.next;
        }
        return 0;
    }

    static int findLength(ListNode _head) {
        ListNode tmp = _head;
        int count = 0;
        while (tmp != null) {
            tmp = tmp.next;
            count++;
        }
        return count;
    }

}
