package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/">2. Add Two Numbers</a>.
 */
class Problem0002 extends LeetcodeProblem {

    ListNode addTwoNumbers(ListNode _ln1, ListNode _ln2) {
        java.math.BigDecimal sum = ListNode.toBigDecimal(_ln1, true).add(ListNode.toBigDecimal(_ln2, true));
        return ListNode.fromBigDecimal(sum);
    }

    static List<Integer> toList(ListNode _ln) {
        List<Integer> l = new ArrayList<>(_ln.val);
        ListNode node = _ln;
        while (node != null) {
            l.add(node.val);
            node = node.next;
        }
        return l;
    }

}
