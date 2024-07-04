package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 1698. Number of Distinct Substrings in a String.
 */
class Problem1698 extends LeetcodeProblem {

    int countDistinct(String s) {
        Set<String> ss = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                ss.add(s.substring(i, j));
            }
        }
        return ss.size();
    }

}
