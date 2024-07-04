package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/">2130. Maximum Twin Sum of a Linked
 * List</a>.
 */
class Problem2130 extends LeetcodeProblem {

    static int pairSum(ListNode _head) {
        List<Integer> values = new ArrayList<>();
        ListNode curr = _head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        final int len = values.size();
        int sum = 0;
        for (int i = 0; i < len / 2; i++) {
            sum = Math.max(sum, values.get(i) + values.get(len - 1 - i));

        }

        return sum;
    }

}
