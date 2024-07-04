package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1093. Statistics from a Large Sample.
 */
class Problem1093 extends LeetcodeProblem {

    private int[] count;

    double[] sampleStats(int[] _count) {
        count = _count;
        int mi = 1 << 30;
        int mx = -1;
        long s = 0;
        int cnt = 0;
        int mode = 0;
        for (int k = 0; k < _count.length; k++) {
            if (_count[k] > 0) {
                mi = Math.min(mi, k);
                mx = Math.max(mx, k);
                s += 1L * k * _count[k];
                cnt += _count[k];
                if (_count[k] > _count[mode]) {
                    mode = k;
                }
            }
        }
        double median = cnt % 2 == 1 ? find(cnt / 2 + 1) : (find(cnt / 2) + find(cnt / 2 + 1)) / 2.0;
        return new double[] {mi, mx, s * 1.0 / cnt, median, mode};
    }

    private int find(int _i) {
        for (int k = 0, t = 0;; k++) {
            t += count[k];
            if (t >= _i) {
                return k;
            }
        }
    }

}
