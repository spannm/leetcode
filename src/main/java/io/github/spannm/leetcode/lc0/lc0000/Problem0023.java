package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/">23. Merge k Sorted Lists</a>.
 */
class Problem0023 extends LeetcodeProblem {

    ListNode mergeKLists(ListNode[] _lists) {
        if (_lists == null || _lists.length == 0) {
            return null;
        }
        return divideAndConquer(_lists, 0, _lists.length - 1);
    }

    static ListNode divideAndConquer(ListNode[] _lists, int _idxBgn, int _idxEnd) {
        if (_idxBgn == _idxEnd) {
            return _lists[_idxBgn];
        } else if (_idxBgn + 1 == _idxEnd) {
            return mergeSort(_lists[_idxBgn], _lists[_idxEnd]);
        }

        final int idxMid = _idxBgn + (_idxEnd - _idxBgn) / 2;
        ListNode listLeft = divideAndConquer(_lists, _idxBgn, idxMid);
        ListNode listRight = divideAndConquer(_lists, idxMid + 1, _idxEnd);

        return mergeSort(listLeft, listRight);
    }

    static ListNode mergeSort(ListNode _list1, ListNode _list2) {
        ListNode merged = new ListNode(0);
        ListNode curr = merged;

        while (_list1 != null && _list2 != null) {
            if (_list1.val < _list2.val) {
                curr.next = _list1;
                _list1 = _list1.next;
            } else {
                curr.next = _list2;
                _list2 = _list2.next;
            }
            curr = curr.next;
        }

        if (_list1 != null) {
            curr.next = _list1;
        } else {
            curr.next = _list2;
        }

        return merged.next;
    }

}
