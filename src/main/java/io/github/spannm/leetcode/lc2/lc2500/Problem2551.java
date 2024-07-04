package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/put-marbles-in-bags/">2551. Put Marbles in Bags</a>.
 */
class Problem2551 extends LeetcodeProblem {

    long putMarbles(final int[] _weights, final int _nbBags) {
        int n = _weights.length - 1;
        long[] w2 = new long[n];
        for (int i = 0; i < w2.length; i++) {
            w2[i] = _weights[i] + _weights[i + 1];
        }
        Arrays.sort(w2);
        long res = 0;
        for (int i = 0; i < _nbBags - 1; i++) {
            res += w2[n - 1 - i] - w2[i];
        }
        return res;
    }

}
