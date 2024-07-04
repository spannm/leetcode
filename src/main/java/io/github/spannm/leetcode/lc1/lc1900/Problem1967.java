package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1967 extends LeetcodeProblem {

    int numOfStrings(String[] _patterns, String _word) {
        return (int) Arrays.stream(_patterns).filter(_word::contains).count();
    }

}
