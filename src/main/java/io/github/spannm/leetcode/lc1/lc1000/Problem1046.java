package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/last-stone-weight/">1046. Last Stone Weight</a>.
 */
class Problem1046 extends LeetcodeProblem {

    int lastStoneWeight(final int[] _weights) {
        final int len = _weights.length;
        if (len <= 1) {
            return len == 0 ? 0 : _weights[0];
        }

        for (int i = len - 1; i >= 0; i--) {
            Arrays.sort(_weights);

            if (i == 0) {
                return _weights[i];
            }
            int w1 = _weights[i];
            int w2 = _weights[i - 1];
            int diff = w1 - w2;
            if (diff == 0) {
                i--;
            } else {
                _weights[i - 1] = diff > 0 ? diff : -diff;
            }
        }

        return 0;
    }

}
