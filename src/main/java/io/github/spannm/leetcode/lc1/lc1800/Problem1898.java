package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 1898. Maximum Number of Removable Characters.
 */
class Problem1898 extends LeetcodeProblem {

    int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (check(s, p, removable, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(String s, String p, int[] removable, int mid) {
        int m = s.length();
        int n = p.length();
        int i = 0;
        int j = 0;
        Set<Integer> ids = new HashSet<>();
        for (int k = 0; k < mid; k++) {
            ids.add(removable[k]);
        }
        while (i < m && j < n) {
            if (!ids.contains(i) && s.charAt(i) == p.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == n;
    }

}
