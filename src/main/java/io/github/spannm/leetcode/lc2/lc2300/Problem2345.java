package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2345. Finding the Number of Visible Mountains.
 */
class Problem2345 extends LeetcodeProblem {

    int visibleMountains(int[][] peaks) {
        int n = peaks.length;
        int[][] arr = new int[n][2];
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = peaks[i][0];
            int y = peaks[i][1];
            arr[i] = new int[] {x - y, x + y};
            cnt.merge(x - y + "" + (x + y), 1, Integer::sum);
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int ans = 0;
        int cur = Integer.MIN_VALUE;
        for (int[] e : arr) {
            int l = e[0];
            int r = e[1];
            if (r <= cur) {
                continue;
            }
            cur = r;
            if (cnt.get(l + "" + r) == 1) {
                ans++;
            }
        }
        return ans;
    }

}
