package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2306. Naming a Company.
 */
class Problem2306 extends LeetcodeProblem {

    long distinctNames(String[] ideas) {
        Set<String> s = new HashSet<>(Arrays.asList(ideas));
        int[][] f = new int[26][26];
        for (String v : ideas) {
            char[] t = v.toCharArray();
            int i = t[0] - 'a';
            for (int j = 0; j < 26; j++) {
                t[0] = (char) (j + 'a');
                if (!s.contains(String.valueOf(t))) {
                    f[i][j]++;
                }
            }
        }
        long ans = 0;
        for (String v : ideas) {
            char[] t = v.toCharArray();
            int i = t[0] - 'a';
            for (int j = 0; j < 26; j++) {
                t[0] = (char) (j + 'a');
                if (!s.contains(String.valueOf(t))) {
                    ans += f[j][i];
                }
            }
        }
        return ans;
    }

}
