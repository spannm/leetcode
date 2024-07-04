package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

import java.util.ArrayList;
import java.util.List;

class Problem1171 extends LeetcodeProblem {

    ListNode removeZeroSumSublists(ListNode _head) {
        List<Integer> list = convertToList(_head);
        int size;
        do {
            size = list.size();
            list = shrinkList(list);
        } while (list.size() != size);
        return recoverLinkedList(list);
    }

    static List<Integer> convertToList(ListNode _head) {
        List<Integer> list = new ArrayList<>();
        while (_head != null) {
            if (_head.val != 0) {
                list.add(_head.val);
            }
            _head = _head.next;
        }
        return list;
    }

    static List<Integer> shrinkList(List<Integer> _list) {
        for (int i = 0; i < _list.size(); i++) {
            int start = i;
            List<Integer> preSumList = new ArrayList<>();
            for (int k = 0; k < start; k++) {
                preSumList.add(0);
            }
            preSumList.add(_list.get(i));
            for (int k = i; k < _list.size(); k++) {
                if (k > start) {
                    int sum = preSumList.get(k - 1) + _list.get(k);
                    if (sum == 0) {
                        List<Integer> shrinkedList = new ArrayList<>();
                        for (int j = 0; j < start; j++) {
                            shrinkedList.add(_list.get(j));
                        }
                        for (int j = k + 1; j < _list.size(); j++) {
                            shrinkedList.add(_list.get(j));
                        }
                        return shrinkedList;
                    } else {
                        preSumList.add(sum);
                    }
                }
            }
        }
        return _list;
    }

    static ListNode recoverLinkedList(List<Integer> _list) {
        ListNode pre = new ListNode(-1);
        ListNode tmp = pre;
        for (Integer element : _list) {
            tmp.next = new ListNode(element);
            tmp = tmp.next;
        }
        return pre.next;
    }

}
