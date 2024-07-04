package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1230. Toss Strange Coins.
 */
class Problem1230 extends LeetcodeProblem {

    double probabilityOfHeads(double[] _prob, int _target) {
        double[] f = new double[_target + 1];
        f[0] = 1;
        for (double p : _prob) {
            for (int j = _target; j >= 0; j--) {
                f[j] *= 1 - p;
                if (j > 0) {
                    f[j] += p * f[j - 1];
                }
            }
        }
        return f[_target];
    }

}
