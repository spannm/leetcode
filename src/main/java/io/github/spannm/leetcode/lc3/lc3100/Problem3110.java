package io.github.spannm.leetcode.lc3.lc3100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

/**
 * 3110. Score of a String.
 */
class Problem3110 extends LeetcodeProblem {

    int scoreOfString(String _s) {
        return IntStream.range(1, _s.length()).map(i -> Math.abs(_s.charAt(i - 1) - _s.charAt(i))).sum();
    }

}
