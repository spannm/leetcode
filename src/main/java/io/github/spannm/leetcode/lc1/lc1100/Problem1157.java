package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem1157 extends LeetcodeProblem {
    static class MajorityChecker {
        private final SegmentTree                 tree;
        private final Map<Integer, List<Integer>> d;

        MajorityChecker(int[] _arr) {
            tree = new SegmentTree(_arr);
            d = new HashMap<>();
            for (int i = 0; i < _arr.length; i++) {
                d.computeIfAbsent(_arr[i], k -> new ArrayList<>()).add(i);
            }
        }

        int query(int _left, int _right, int _threshold) {
            int x = tree.query(1, _left + 1, _right + 1)[0];
            int l = search(d.get(x), _left);
            int r = search(d.get(x), _right + 1);
            return r - l >= _threshold ? x : -1;
        }

        static int search(List<Integer> _arr, int _x) {
            int left = 0;
            int right = _arr.size();
            while (left < right) {
                int mid = left + right >> 1;
                if (_arr.get(mid) >= _x) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

    }

    static class Node {
        private int l;
        private int r;
        private int x;
        private int cnt;
    }

    static class SegmentTree {
        private final Node[] tr;
        private final int[]  nums;

        SegmentTree(int[] _nums) {
            int len = _nums.length;
            nums = _nums;
            tr = new Node[len << 2];
            for (int i = 0; i < tr.length; i++) {
                tr[i] = new Node();
            }
            build(1, 1, len);
        }

        private void build(int _u, int _l, int _r) {
            tr[_u].l = _l;
            tr[_u].r = _r;
            if (_l == _r) {
                tr[_u].x = nums[_l - 1];
                tr[_u].cnt = 1;
                return;
            }
            int mid = _l + _r >> 1;
            build(_u << 1, _l, mid);
            build(_u << 1 | 1, mid + 1, _r);
            pushup(_u);
        }

        int[] query(int _u, int _l, int _r) {
            if (tr[_u].l >= _l && tr[_u].r <= _r) {
                return new int[] {tr[_u].x, tr[_u].cnt};
            }
            int mid = tr[_u].l + tr[_u].r >> 1;
            if (_r <= mid) {
                return query(_u << 1, _l, _r);
            } else if (_l > mid) {
                return query(_u << 1 | 1, _l, _r);
            }
            var left = query(_u << 1, _l, _r);
            var right = query(_u << 1 | 1, _l, _r);
            if (left[0] == right[0]) {
                left[1] += right[1];
            } else if (left[1] >= right[1]) {
                left[1] -= right[1];
            } else {
                right[1] -= left[1];
                left = right;
            }
            return left;
        }

        private void pushup(int u) {
            if (tr[u << 1].x == tr[u << 1 | 1].x) {
                tr[u].x = tr[u << 1].x;
                tr[u].cnt = tr[u << 1].cnt + tr[u << 1 | 1].cnt;
            } else if (tr[u << 1].cnt >= tr[u << 1 | 1].cnt) {
                tr[u].x = tr[u << 1].x;
                tr[u].cnt = tr[u << 1].cnt - tr[u << 1 | 1].cnt;
            } else {
                tr[u].x = tr[u << 1 | 1].x;
                tr[u].cnt = tr[u << 1 | 1].cnt - tr[u << 1].cnt;
            }
        }

    }

}
