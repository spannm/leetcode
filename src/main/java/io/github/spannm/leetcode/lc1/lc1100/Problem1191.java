package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1191. K-Concatenation Maximum Sum.
 */
class Problem1191 extends LeetcodeProblem {

    int kConcatenationMaxSum(int[] _arr, int _k) {
        long s = 0;
        long mxPre = 0;
        long miPre = 0;
        long mxSub = 0;
        for (int x : _arr) {
            s += x;
            mxPre = Math.max(mxPre, s);
            miPre = Math.min(miPre, s);
            mxSub = Math.max(mxSub, s - miPre);
        }
        long ans = mxSub;
        final int mod = (int) 1e9 + 7;
        if (_k == 1) {
            return (int) (ans % mod);
        }
        long mxSuf = s - miPre;
        ans = Math.max(ans, mxPre + mxSuf);
        if (s > 0) {
            ans = Math.max(ans, (_k - 2) * s + mxPre + mxSuf);
        }
        return (int) (ans % mod);
    }

}
