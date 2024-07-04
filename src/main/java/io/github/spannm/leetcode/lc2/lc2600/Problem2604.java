package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2604. Minimum Time to Eat All Grains.
 */
class Problem2604 extends LeetcodeProblem {

    private int[] hens;
    private int[] grains;
    private int   len;

    int minimumTime(int[] _hens, int[] _grains) {
        hens = _hens;
        grains = _grains;
        len = _grains.length;
        Arrays.sort(_hens);
        Arrays.sort(_grains);
        int l = 0;
        int r = Math.abs(_hens[0] - _grains[0]) + _grains[len - 1] - _grains[0];
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int _t) {
        int j = 0;
        for (int x : hens) {
            if (j == len) {
                return true;
            }
            int y = grains[j];
            if (y <= x) {
                int d = x - y;
                if (d > _t) {
                    return false;
                }
                while (j < len && grains[j] <= x) {
                    j++;
                }
                while (j < len && Math.min(d, grains[j] - x) + grains[j] - y <= _t) {
                    j++;
                }
            } else {
                while (j < len && grains[j] - x <= _t) {
                    j++;
                }
            }
        }
        return j == len;
    }

}
