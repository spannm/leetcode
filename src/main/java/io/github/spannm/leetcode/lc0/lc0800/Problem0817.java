package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. Linked List Components.
 */
class Problem0817 extends LeetcodeProblem {

    int numComponents(ListNode _head, int[] _nums) {
        int ans = 0;
        Set<Integer> s = new HashSet<>();
        for (int v : _nums) {
            s.add(v);
        }
        while (_head != null) {
            while (_head != null && !s.contains(_head.val)) {
                _head = _head.next;
            }
            ans += _head != null ? 1 : 0;
            while (_head != null && s.contains(_head.val)) {
                _head = _head.next;
            }
        }
        return ans;
    }

}
