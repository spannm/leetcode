package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1840. Maximum Building Height.
 */
class Problem1840 extends LeetcodeProblem {

    int maxBuilding(int n, int[][] restrictions) {
        List<int[]> r = new ArrayList<>(Arrays.asList(restrictions));
        r.add(new int[] {1, 0});
        r.sort(Comparator.comparingInt(a -> a[0]));
        if (r.get(r.size() - 1)[0] != n) {
            r.add(new int[] {n, n - 1});
        }
        int m = r.size();
        for (int i = 1; i < m; i++) {
            int[] a = r.get(i - 1);
            int[] b = r.get(i);
            b[1] = Math.min(b[1], a[1] + b[0] - a[0]);
        }
        for (int i = m - 2; i > 0; i--) {
            int[] a = r.get(i);
            int[] b = r.get(i + 1);
            a[1] = Math.min(a[1], b[1] + b[0] - a[0]);
        }
        int ans = 0;
        for (int i = 0; i < m - 1; i++) {
            int[] a = r.get(i);
            int[] b = r.get(i + 1);
            int t = (a[1] + b[1] + b[0] - a[0]) / 2;
            ans = Math.max(ans, t);
        }
        return ans;
    }

}
