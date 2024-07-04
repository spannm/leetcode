package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

class Problem1669 extends LeetcodeProblem {

    ListNode mergeInBetween(ListNode _list1, int _a, int _b, ListNode _list2) {
        ListNode pre = new ListNode(-1);
        ListNode list1Temp = _list1;
        pre.next = list1Temp;
        _b -= _a;
        while (_a > 1) {
            list1Temp = list1Temp.next;
            _a--;
        }
        ListNode tail = list1Temp.next;
        list1Temp.next = _list2;
        while (_b > 0) {
            tail = tail.next;
            _b--;
        }
        int length = 0;
        ListNode temp2 = _list2;
        while (temp2 != null) {
            temp2 = temp2.next;
            length++;
        }
        while (length > 0) {
            list1Temp = list1Temp.next;
            length--;
        }
        list1Temp.next = tail.next;
        return pre.next;
    }

}
