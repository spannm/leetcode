package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1231. Divide Chocolate.
 */
class Problem1231 extends LeetcodeProblem {

    int maximizeSweetness(int[] _sweetness, int _k) {
        int l = 0;
        int r = 0;
        for (int v : _sweetness) {
            r += v;
        }
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(_sweetness, mid, _k)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    static boolean check(int[] _nums, int _x, int _k) {
        int s = 0;
        int cnt = 0;
        for (int v : _nums) {
            s += v;
            if (s >= _x) {
                s = 0;
                cnt++;
            }
        }
        return cnt > _k;
    }

}
