package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">138. Copy List with Random Pointer</a>.
 */
class Problem0138 extends LeetcodeProblem {

    Node copyRandomList(final Node _head) {
        Map<Node, Node> old2New = new HashMap<>();

        Node curr = _head;
        while (curr != null) {
            old2New.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = _head;
        while (curr != null) {
            Node copy = old2New.get(curr);
            copy.next = old2New.get(curr.next);
            copy.random = old2New.get(curr.random);
            curr = curr.next;
        }

        Node result = old2New.get(_head);

        old2New = null;

        return result;
    }

    static class Node {
        private final int val;
        private Node      next;
        private Node      random;

        Node(int _val) {
            val = _val;
            next = null;
            random = null;
        }
    }

}
