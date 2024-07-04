package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem1062 extends LeetcodeProblem {

    int longestRepeatingSubstring(String _s) {
        Set<String> seen = new HashSet<>();
        for (int j = _s.length() - 1; j > 0; j--) {
            int len = j;
            for (int i = 0; i <= _s.length() - j; i++) {
                if (!seen.add(_s.substring(i, i + len))) {
                    return len;
                }
            }
            seen.clear();
        }
        return 0;
    }

}
