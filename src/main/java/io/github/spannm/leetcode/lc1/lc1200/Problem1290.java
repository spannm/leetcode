package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

class Problem1290 extends LeetcodeProblem {

    int getDecimalValue(ListNode _head) {
        StringBuilder sb = new StringBuilder();
        while (_head != null) {
            sb.append(_head.val);
            _head = _head.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }

}
