package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2171. Removing Minimum Number of Magic Beans.
 */
class Problem2171 extends LeetcodeProblem {

    long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long s = 0;
        for (int v : beans) {
            s += v;
        }
        long ans = s;
        int n = beans.length;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, s - (long) beans[i] * (n - i));
        }
        return ans;
    }

}
