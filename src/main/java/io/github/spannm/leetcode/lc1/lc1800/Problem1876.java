package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1876 extends LeetcodeProblem {

    int countGoodSubstrings(String _s) {
        int count = 0;
        for (int i = 0; i < _s.length() - 2; i++) {
            String candidate = _s.substring(i, i + 3);
            if (candidate.charAt(0) != candidate.charAt(1) && candidate.charAt(0) != candidate.charAt(2) && candidate.charAt(1) != candidate.charAt(2)) {
                count++;
            }
        }
        return count;
    }

}
