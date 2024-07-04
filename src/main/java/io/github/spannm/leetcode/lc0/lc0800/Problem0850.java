package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 850. Rectangle Area II.
 */
class Problem0850 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;

    int rectangleArea(int[][] _rectangles) {
        int n = _rectangles.length;
        int[][] segs = new int[n << 1][4];
        int i = 0;
        TreeSet<Integer> ts = new TreeSet<>();
        for (int[] rect : _rectangles) {
            int x1 = rect[0];
            int y1 = rect[1];
            int x2 = rect[2];
            int y2 = rect[3];
            segs[i++] = new int[] {x1, y1, y2, 1};
            segs[i++] = new int[] {x2, y1, y2, -1};
            ts.add(y1);
            ts.add(y2);
        }
        Arrays.sort(segs, Comparator.comparingInt(a -> a[0]));
        Map<Integer, Integer> m = new HashMap<>(ts.size());
        i = 0;
        int[] nums = new int[ts.size()];
        for (int v : ts) {
            m.put(v, i);
            nums[i++] = v;
        }

        SegmentTree tree = new SegmentTree(nums);
        long ans = 0;
        for (i = 0; i < segs.length; i++) {
            var e = segs[i];
            int x = e[0];
            int y1 = e[1];
            int y2 = e[2];
            int k = e[3];
            if (i > 0) {
                ans += (long) tree.query() * (x - segs[i - 1][0]);
            }
            tree.modify(1, m.get(y1), m.get(y2) - 1, k);
        }
        ans %= MOD;
        return (int) ans;
    }

    static class Node {
        private int l;
        private int r;
        private int cnt;
        private int length;
    }

    static class SegmentTree {
        private final Node[] tr;
        private final int[]  nums;

        SegmentTree(int[] _nums) {
            nums = _nums;
            int n = _nums.length - 1;
            tr = new Node[n << 2];
            for (int i = 0; i < tr.length; i++) {
                tr[i] = new Node();
            }
            build(1, 0, n - 1);
        }

        void build(int _u, int _l, int _r) {
            tr[_u].l = _l;
            tr[_u].r = _r;
            if (_l != _r) {
                int mid = _l + _r >> 1;
                build(_u << 1, _l, mid);
                build(_u << 1 | 1, mid + 1, _r);
            }
        }

        void modify(int _u, int _l, int _r, int _k) {
            if (tr[_u].l >= _l && tr[_u].r <= _r) {
                tr[_u].cnt += _k;
            } else {
                int mid = tr[_u].l + tr[_u].r >> 1;
                if (_l <= mid) {
                    modify(_u << 1, _l, _r, _k);
                }
                if (_r > mid) {
                    modify(_u << 1 | 1, _l, _r, _k);
                }
            }
            pushup(_u);
        }

        void pushup(int _u) {
            if (tr[_u].cnt > 0) {
                tr[_u].length = nums[tr[_u].r + 1] - nums[tr[_u].l];
            } else if (tr[_u].l == tr[_u].r) {
                tr[_u].length = 0;
            } else {
                tr[_u].length = tr[_u << 1].length + tr[_u << 1 | 1].length;
            }
        }

        int query() {
            return tr[1].length;
        }

    }

}
