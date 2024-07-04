package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/design-hashmap/">706. Design HashMap</a>.
 */
class Problem0706 extends LeetcodeProblem {

    static class MyHashMap {

        private final ListNode[] nodes = new ListNode[10000];

        public void put(int _key, int _value) {
            int i = idx(_key);
            if (nodes[i] == null) {
                nodes[i] = new ListNode(-1, -1);
            }
            ListNode prev = find(nodes[i], _key);
            if (prev.next == null) {
                prev.next = new ListNode(_key, _value);
            } else {
                prev.next.val = _value;
            }
        }

        public int get(int _key) {
            int i = idx(_key);
            if (nodes[i] == null) {
                return -1;
            }
            ListNode node = find(nodes[i], _key);
            return node.next == null ? -1 : node.next.val;
        }

        public void remove(int _key) {
            int i = idx(_key);
            if (nodes[i] == null) {
                return;
            }
            ListNode prev = find(nodes[i], _key);
            if (prev.next == null) {
                return;
            }
            prev.next = prev.next.next;
        }

        int idx(int _key) {
            return Integer.hashCode(_key) % nodes.length;
        }

        ListNode find(ListNode _bucket, int _key) {
            ListNode node = _bucket;
            ListNode prev = null;
            while (node != null && node.key != _key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }

        static class ListNode {
            private final int key;
            private int       val;
            private ListNode  next;

            ListNode(int _key, int _val) {
                key = _key;
                val = _val;
            }
        }
    }

}
