package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 2128. Remove All Ones With Row and Column Flips.
 */
class Problem2128 extends LeetcodeProblem {

    boolean removeOnes(int[][] grid) {
        Set<String> s = new HashSet<>();
        int n = grid[0].length;
        for (var row : grid) {
            var cs = new char[n];
            for (int i = 0; i < n; i++) {
                cs[i] = (char) (row[0] ^ row[i]);
            }
            s.add(String.valueOf(cs));
        }
        return s.size() == 1;
    }

}
