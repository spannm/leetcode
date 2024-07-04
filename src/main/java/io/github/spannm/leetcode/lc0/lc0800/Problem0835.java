package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 835. Image Overlap.
 */
class Problem0835 extends LeetcodeProblem {

    int largestOverlap(int[][] _img1, int[][] _img2) {
        int n = _img1.length;
        Map<List<Integer>, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (_img1[i][j] == 1) {
                    for (int h = 0; h < n; h++) {
                        for (int k = 0; k < n; k++) {
                            if (_img2[h][k] == 1) {
                                List<Integer> t = List.of(i - h, j - k);
                                ans = Math.max(ans, cnt.merge(t, 1, Integer::sum));
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

}
