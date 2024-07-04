package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 2747. Count Zero Request Servers.
 */
class Problem2747 extends LeetcodeProblem {

    int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));
        int m = queries.length;
        int[][] qs = new int[m][0];
        for (int i = 0; i < m; i++) {
            qs[i] = new int[] {queries[i], i};
        }
        Arrays.sort(qs, Comparator.comparingInt(a -> a[0]));
        Map<Integer, Integer> cnt = new HashMap<>();
        int[] ans = new int[m];
        int j = 0;
        int k = 0;
        for (var q : qs) {
            int r = q[0];
            int i = q[1];
            int l = r - x;
            while (k < logs.length && logs[k][1] <= r) {
                cnt.merge(logs[k++][0], 1, Integer::sum);
            }
            while (j < logs.length && logs[j][1] < l) {
                if (cnt.merge(logs[j][0], -1, Integer::sum) == 0) {
                    cnt.remove(logs[j][0]);
                }
                j++;
            }
            ans[i] = n - cnt.size();
        }
        return ans;
    }

}
