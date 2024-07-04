package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Random;

class Problem1206 extends LeetcodeProblem {

    static class Skiplist {
        private static final int    MAX_LEVEL = 32;
        private static final double P         = 0.25;
        private static final Random RANDOM    = new Random();
        private final Node          head      = new Node(-1, MAX_LEVEL);
        private int                 level     = 0;

        Skiplist() {
        }

        boolean search(int _target) {
            Node curr = head;
            for (int i = level - 1; i >= 0; i--) {
                curr = findClosest(curr, i, _target);
                if (curr.next[i] != null && curr.next[i].val == _target) {
                    return true;
                }
            }
            return false;
        }

        void add(int _num) {
            Node curr = head;
            int lv = randomLevel();
            Node node = new Node(_num, lv);
            level = Math.max(level, lv);
            for (int i = level - 1; i >= 0; i--) {
                curr = findClosest(curr, i, _num);
                if (i < lv) {
                    node.next[i] = curr.next[i];
                    curr.next[i] = node;
                }
            }
        }

        boolean erase(int _num) {
            Node curr = head;
            boolean ok = false;
            for (int i = level - 1; i >= 0; i--) {
                curr = findClosest(curr, i, _num);
                if (curr.next[i] != null && curr.next[i].val == _num) {
                    curr.next[i] = curr.next[i].next[i];
                    ok = true;
                }
            }
            while (level > 1 && head.next[level - 1] == null) {
                level--;
            }
            return ok;
        }

        private Node findClosest(Node _curr, int _level, int _target) {
            while (_curr.next[_level] != null && _curr.next[_level].val < _target) {
                _curr = _curr.next[_level];
            }
            return _curr;
        }

        private static int randomLevel() {
            int level = 1;
            while (level < MAX_LEVEL && RANDOM.nextDouble() < P) {
                level++;
            }
            return level;
        }

        static class Node {
            private final int    val;
            private final Node[] next;

            Node(int _val, int _level) {
                val = _val;
                next = new Node[_level];
            }
        }

    }

}
