package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 2487. Remove Nodes From Linked List.
 */
class Problem2487 extends LeetcodeProblem {

    ListNode removeNodes(ListNode _head) {
        List<Integer> nums = new ArrayList<>();
        while (_head != null) {
            nums.add(_head.val);
            _head = _head.next;
        }
        Deque<Integer> stk = new ArrayDeque<>();
        for (int n : nums) {
            while (!stk.isEmpty() && stk.peek() < n) {
                stk.pop();
            }
            stk.push(n);
        }
        ListNode save = new ListNode();
        _head = save;
        while (!stk.isEmpty()) {
            _head.next = new ListNode(stk.pollLast());
            _head = _head.next;
        }
        return save.next;
    }

}
