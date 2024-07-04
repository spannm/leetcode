package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 1505. Minimum Possible Integer After at Most K Adjacent Swaps On Digits.
 */
class Problem1505 extends LeetcodeProblem {

    String minInteger(String _num, int _k) {
        List<Queue<Integer>> pos = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            pos.add(new ArrayDeque<>());
        }
        int n = _num.length();
        for (int i = 0; i < n; i++) {
            pos.get(_num.charAt(i) - '0').offer(i + 1);
        }
        StringBuilder ans = new StringBuilder();
        BinaryIndexedTree tree = new BinaryIndexedTree(n);
        for (int i = 1; i <= n; i++) {
            for (int v = 0; v < 10; v++) {
                if (!pos.get(v).isEmpty()) {
                    var q = pos.get(v);
                    int j = q.peek();
                    int dist = tree.query(n) - tree.query(j) + j - i;
                    if (dist <= _k) {
                        _k -= dist;
                        q.poll();
                        ans.append(v);
                        tree.update(j, 1);
                        break;
                    }
                }
            }
        }
        return ans.toString();
    }

    static class BinaryIndexedTree {
        private final int   n;
        private final int[] c;

        BinaryIndexedTree(int _n) {
            n = _n;
            c = new int[_n + 1];
        }

        void update(int _x, int _delta) {
            while (_x <= n) {
                c[_x] += _delta;
                _x += lowbit(_x);
            }
        }

        int query(int _x) {
            int s = 0;
            while (_x > 0) {
                s += c[_x];
                _x -= lowbit(_x);
            }
            return s;
        }

        static int lowbit(int _x) {
            return _x & -_x;
        }

    }

}
