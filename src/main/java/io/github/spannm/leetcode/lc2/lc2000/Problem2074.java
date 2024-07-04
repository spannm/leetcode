package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem2074 extends LeetcodeProblem {

    ListNode reverseEvenLengthGroups(ListNode _head) {
        List<Integer> list = new ArrayList<>();
        ListNode tmp = _head;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        int len = 1;
        int start = 0;
        List<Integer> reversed = new ArrayList<>();
        while (start + len <= list.size()) {
            if (len % 2 == 0) {
                List<Integer> sub = list.subList(start, start + len);
                Collections.reverse(sub);
                reversed.addAll(sub);
            } else {
                reversed.addAll(list.subList(start, start + len));
            }
            start += len;
            len++;
        }
        if (start < list.size()) {
            List<Integer> sublist = list.subList(start, list.size());
            if (sublist.size() % 2 == 0) {
                Collections.reverse(sublist);
            }
            reversed.addAll(sublist);
        }
        ListNode pre = new ListNode(-1);
        _head = new ListNode(reversed.get(0));
        pre.next = _head;
        for (int i = 1; i < reversed.size(); i++) {
            _head.next = new ListNode(reversed.get(i));
            _head = _head.next;
        }
        return pre.next;
    }

}
