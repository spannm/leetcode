package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2121. Intervals Between Identical Elements.
 */
class Problem2121 extends LeetcodeProblem {

    long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> d = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            d.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        long[] ans = new long[n];
        for (List<Integer> v : d.values()) {
            int m = v.size();
            long val = 0;
            for (int e : v) {
                val += e;
            }
            val -= m * v.get(0);
            for (int i = 0; i < v.size(); i++) {
                int delta = i >= 1 ? v.get(i) - v.get(i - 1) : 0;
                val += i * delta - (m - i) * delta;
                ans[v.get(i)] = val;
            }
        }
        return ans;
    }

}
