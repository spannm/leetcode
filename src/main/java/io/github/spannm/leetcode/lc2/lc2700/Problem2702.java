package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2702. Minimum Operations to Make Numbers Non-positive.
 */
class Problem2702 extends LeetcodeProblem {

    private int[] nums;
    private int   x;
    private int   y;

    int minOperations(int[] _nums, int _x, int _y) {
        nums = _nums;
        x = _x;
        y = _y;
        int l = 0;
        int r = 0;
        for (int v : _nums) {
            r = Math.max(r, v);
        }
        while (l < r) {
            int mid = l + r >>> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    boolean check(int t) {
        long cnt = 0;
        for (int v : nums) {
            if (v > (long) t * y) {
                cnt += (v - (long) t * y + x - y - 1) / (x - y);
            }
        }
        return cnt <= t;
    }

}
