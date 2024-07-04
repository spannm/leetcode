package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 2607. Make K-Subarray Sums Equal.
 */
class Problem2607 extends LeetcodeProblem {

    long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        int g = gcd(n, k);
        long ans = 0;
        for (int i = 0; i < g; i++) {
            List<Integer> t = new ArrayList<>();
            for (int j = i; j < n; j += g) {
                t.add(arr[j]);
            }
            t.sort(Comparator.comparingInt(a -> a));
            int mid = t.get(t.size() >> 1);
            for (int x : t) {
                ans += Math.abs(x - mid);
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
