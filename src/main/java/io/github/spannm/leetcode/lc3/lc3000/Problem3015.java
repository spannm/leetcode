package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3015. Count the Number of Houses at a Certain Distance I.
 */
class Problem3015 extends LeetcodeProblem {

    int[] countOfPairs(int _n, int _x, int _y) {
        int[] ans = new int[_n];
        _x--;
        _y--;
        for (int i = 0; i < _n; i++) {
            for (int j = i + 1; j < _n; j++) {
                int a = j - i;
                int b = Math.abs(i - _x) + 1 + Math.abs(j - _y);
                int c = Math.abs(i - _y) + 1 + Math.abs(j - _x);
                ans[Math.min(a, Math.min(b, c)) - 1] += 2;
            }
        }
        return ans;
    }

}
