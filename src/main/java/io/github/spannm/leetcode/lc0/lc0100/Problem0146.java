package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache/">146. LRU Cache</a>.
 */
class Problem0146 extends LeetcodeProblem {

    static class LRUCache {
        static final int                 NOT_FOUND = -1;

        private final int                capacity;
        private final Node               head      = new Node(0, 0);
        private final Node               tail      = new Node(0, 0);
        private final Map<Integer, Node> store     = new HashMap<>();

        LRUCache(int _capacity) {
            capacity = _capacity;
            head.next = tail;
            tail.prev = head;
        }

        int get(int _key) {
            if (store.containsKey(_key)) {
                Node node = store.get(_key);
                remove(node);
                insert(node);
                return node.val;
            }
            return NOT_FOUND;
        }

        void put(int _key, int _value) {
            if (store.containsKey(_key)) {
                remove(store.get(_key));
            }
            if (store.size() == capacity) {
                remove(tail.prev);
            }
            insert(new Node(_key, _value));
        }

        private void remove(final Node _node) {
            store.remove(_node.key);
            _node.prev.next = _node.next;
            _node.next.prev = _node.prev;
        }

        private void insert(final Node _node) {
            store.put(_node.key, _node);
            Node headNext = head.next;
            head.next = _node;
            _node.prev = head;
            headNext.prev = _node;
            _node.next = headNext;
        }
    }

    static class Node {
        private final int key;
        private final int val;
        private Node      prev;
        private Node      next;

        Node(int _key, int _val) {
            key = _key;
            val = _val;
        }
    }

}
