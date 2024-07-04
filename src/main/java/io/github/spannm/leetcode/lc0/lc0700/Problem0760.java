package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0760 extends LeetcodeProblem {

    int[] anagramMappings(int[] _a, int[] _b) {
        int[] result = new int[_a.length];
        for (int i = 0; i < _a.length; i++) {
            for (int j = 0; j < _b.length; j++) {
                if (_a[i] == _b[j]) {
                    result[i] = j;
                }
            }
        }
        return result;
    }

}
