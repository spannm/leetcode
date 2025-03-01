package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1787. Make the XOR of All Segments Equal to Zero.
 */
class Problem1787 extends LeetcodeProblem {

    int minChanges(int[] nums, int k) {
        int n = 1 << 10;
        @SuppressWarnings("unchecked")
        Map<Integer, Integer>[] cnt = new Map[k];
        Arrays.setAll(cnt, i -> new HashMap<>());
        int[] size = new int[k];
        for (int i = 0; i < nums.length; i++) {
            int j = i % k;
            cnt[j].merge(nums[i], 1, Integer::sum);
            size[j]++;
        }
        int[] f = new int[n];
        final int inf = 1 << 30;
        Arrays.fill(f, inf);
        f[0] = 0;
        for (int i = 0; i < k; i++) {
            int[] g = new int[n];
            Arrays.fill(g, min(f) + size[i]);
            for (int j = 0; j < n; j++) {
                for (var e : cnt[i].entrySet()) {
                    int v = e.getKey();
                    int c = e.getValue();
                    g[j] = Math.min(g[j], f[j ^ v] + size[i] - c);
                }
            }
            f = g;
        }
        return f[0];
    }

    private int min(int[] arr) {
        int mi = arr[0];
        for (int v : arr) {
            mi = Math.min(mi, v);
        }
        return mi;
    }

}
