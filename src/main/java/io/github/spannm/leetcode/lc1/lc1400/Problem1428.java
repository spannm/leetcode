package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.BinaryMatrix;

import java.util.List;

/**
 * 1428. Leftmost Column with at Least a One.
 */
class Problem1428 extends LeetcodeProblem {

    int leftMostColumnWithOne(BinaryMatrix _binaryMatrix) {
        List<Integer> e = _binaryMatrix.dimensions();
        int m = e.get(0);
        int n = e.get(1);
        int ans = n;
        for (int i = 0; i < m; i++) {
            int l = 0;
            int r = n;
            while (l < r) {
                int mid = l + r >> 1;
                if (_binaryMatrix.get(i, mid) == 1) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            ans = Math.min(ans, l);
        }
        return ans >= n ? -1 : ans;
    }

}
