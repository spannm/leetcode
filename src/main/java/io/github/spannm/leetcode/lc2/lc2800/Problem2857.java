package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2857. Count Pairs of Points With Distance k.
 */
class Problem2857 extends LeetcodeProblem {

    int countPairs(List<List<Integer>> coordinates, int k) {
        Map<List<Integer>, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (var c : coordinates) {
            int x2 = c.get(0);
            int y2 = c.get(1);
            for (int a = 0; a <= k; a++) {
                int b = k - a;
                int x1 = a ^ x2;
                int y1 = b ^ y2;
                ans += cnt.getOrDefault(List.of(x1, y1), 0);
            }
            cnt.merge(c, 1, Integer::sum);
        }
        return ans;
    }

}
