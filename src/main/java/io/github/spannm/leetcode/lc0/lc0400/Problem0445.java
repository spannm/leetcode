package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

import java.math.BigDecimal;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers-ii/">445. Add Two Numbers II</a>.
 */
class Problem0445 extends LeetcodeProblem {

    ListNode addTwoNumbers(ListNode _ln1, ListNode _ln2) {
        BigDecimal bg1 = ListNode.toBigDecimal(_ln1, false);
        BigDecimal bg2 = ListNode.toBigDecimal(_ln2, false);
        BigDecimal sum = bg1.add(bg2);

        return ListNode.fromCharArray(new StringBuilder(sum.toString()).reverse().toString().toCharArray());
    }

}
