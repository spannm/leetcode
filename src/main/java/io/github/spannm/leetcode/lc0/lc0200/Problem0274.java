package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0274 extends LeetcodeProblem {

    int hIndex(int[] _citations) {
        int len = _citations.length;
        if (len == 0) {
            return 0;
        }

        Arrays.sort(_citations);
        for (int i = 0; i < len; i++) {
            if (_citations[i] >= len - i) {
                return len - i;
            }
        }
        return 0;
    }

}
