package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/">712. Minimum ASCII Delete Sum for
 * Two Strings</a>.
 */
class Problem0712 extends LeetcodeProblem {

    int minimumDeleteSum(String _s1, String _s2) {
        final int len1 = _s1.length();
        final int len2 = _s2.length();

        Integer[][] dp = new Integer[len1][len2];

        final int minSum = calc(_s1, _s2, len1, len2, 0, 0, dp);

        _s1 = null;
        _s2 = null;
        dp = null;
        System.gc();

        return minSum;
    }

    static int calc(final String _s1, final String _s2,
        final int _len1, final int _len2,
        final int _idx1, final int _idx2,
        final Integer[][] _dp) {

        if (_idx1 == _len1) {
            return IntStream.range(_idx2, _len2).map(_s2::charAt).sum();
        } else if (_idx2 == _len2) {
            return IntStream.range(_idx1, _len1).map(_s1::charAt).sum();
        } else if (_s1.charAt(_idx1) == _s2.charAt(_idx2)) {
            return calc(_s1, _s2, _len1, _len2, _idx1 + 1, _idx2 + 1, _dp);
        } else if (_dp[_idx1][_idx2] != null) {
            return _dp[_idx1][_idx2];
        }

        int res1 = _s1.charAt(_idx1) + calc(_s1, _s2, _len1, _len2, _idx1 + 1, _idx2, _dp);
        int res2 = _s2.charAt(_idx2) + calc(_s1, _s2, _len1, _len2, _idx1, _idx2 + 1, _dp);

        _dp[_idx1][_idx2] = Math.min(res1, Math.min(res2, res2));
        return _dp[_idx1][_idx2];
    }

}
