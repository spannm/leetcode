package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/split-linked-list-in-parts/">725. Split Linked List in Parts</a>.
 */
class Problem0725 extends LeetcodeProblem {

    ListNode[] splitListToParts(ListNode _head, int _k) {
        if (_k < 1 || _k > 50) {
            throw new IllegalArgumentException("Invalid number of parts");
        } else if (_head == null) {
            return new ListNode[_k];
        }

        ListNode node = _head;
        int len = 1;
        while ((node = node.next) != null) {
            len++;
        }

        int[] partLens = new int[_k];
        int base = len / _k;
        Arrays.fill(partLens, base);
        int remainder = len % _k;
        for (int i = 0; i < _k && remainder > 0; i++) {
            partLens[i] += 1;
            remainder--;
        }

        final ListNode[] split = new ListNode[_k];

        ListNode currNode = _head;
        ListNode prevNode = _head;
        for (int i = 0; i < _k; i++) {
            split[i] = currNode;
            while (partLens[i]-- > 0) {
                prevNode = currNode;
                currNode = currNode.next;
            }
            prevNode.next = null;
        }

        partLens = null;

        return split;
    }

}
