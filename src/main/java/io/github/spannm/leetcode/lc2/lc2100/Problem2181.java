package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

import java.util.ArrayList;
import java.util.List;

class Problem2181 extends LeetcodeProblem {

    ListNode mergeNodes(ListNode _head) {
        List<Integer> list = new ArrayList<>();
        while (_head != null) {
            list.add(_head.val);
            _head = _head.next;
        }
        ListNode pre = new ListNode(-1);
        ListNode tmp = pre;
        for (int i = 1; i < list.size(); i++) {
            int sum = 0;
            while (i < list.size() && list.get(i) != 0) {
                sum += list.get(i);
                i++;
            }
            tmp.next = new ListNode(sum);
            tmp = tmp.next;
        }
        return pre.next;
    }

}
