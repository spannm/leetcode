package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/maximum-length-of-pair-chain/">646. Maximum Length of Pair Chain</a>.
 * <p>
 * <a href=
 * "https://leetcode.com/problems/maximum-length-of-pair-chain/solutions/3960470/98-17-2-approaches-greedy-dynamic-programming/">✅
 * 98.17% 2-Approaches Greedy & Dynamic Programming</a>.
 */
class Problem0646 extends LeetcodeProblem {

    int findLongestChain(int[][] _pairs) {
        java.util.Arrays.sort(_pairs, Comparator.comparingInt(l -> l[1]));

        int cur = -1001;
        int len = 0;

        for (int[] pair : _pairs) {
            if (cur < pair[0]) {
                cur = pair[1];
                len++;
            }
        }

        _pairs = null;
        System.gc();

        return len;
    }

}
