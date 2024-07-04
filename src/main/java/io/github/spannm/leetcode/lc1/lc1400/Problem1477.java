package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum.
 */
class Problem1477 extends LeetcodeProblem {

    int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> d = new HashMap<>();
        d.put(0, 0);
        int n = arr.length;
        int[] f = new int[n + 1];
        final int inf = 1 << 30;
        f[0] = inf;
        int s = 0;
        int ans = inf;
        for (int i = 1; i <= n; i++) {
            int v = arr[i - 1];
            s += v;
            f[i] = f[i - 1];
            if (d.containsKey(s - target)) {
                int j = d.get(s - target);
                f[i] = Math.min(f[i], i - j);
                ans = Math.min(ans, f[j] + i - j);
            }
            d.put(s, i);
        }
        return ans > n ? -1 : ans;
    }

}
