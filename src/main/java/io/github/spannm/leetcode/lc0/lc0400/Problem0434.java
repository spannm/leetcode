package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0434 extends LeetcodeProblem {

    int countSegments(String _s) {
        return _s == null || _s.isEmpty() ? 0
            : (int) Arrays.stream(_s.split(" ")).filter(seg -> !seg.isEmpty()).count();
    }

}
