package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

import java.util.HashMap;
import java.util.Map;

class Problem1836 extends LeetcodeProblem {

    ListNode deleteDuplicatesUnsorted(ListNode _head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode tmp = _head;
        while (tmp != null) {
            map.put(tmp.val, map.getOrDefault(tmp.val, 0) + 1);
            tmp = tmp.next;
        }
        ListNode pre = new ListNode(-1);
        tmp = pre;
        while (_head != null) {
            if (map.get(_head.val) == 1) {
                tmp.next = new ListNode(_head.val);
                tmp = tmp.next;
            }
            _head = _head.next;
        }
        return pre.next;
    }

}
