package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

import java.util.ArrayList;
import java.util.List;

class Problem2095 extends LeetcodeProblem {

    ListNode deleteMiddle(ListNode _head) {
        List<Integer> list = new ArrayList<>();
        while (_head != null) {
            list.add(_head.val);
            _head = _head.next;
        }
        ListNode pre = new ListNode(-1);
        ListNode tmp = pre;
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() / 2) {
                tmp.next = new ListNode(list.get(i));
                tmp = tmp.next;
            }
        }
        return pre.next;
    }

}
