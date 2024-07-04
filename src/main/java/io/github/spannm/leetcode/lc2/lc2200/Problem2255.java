package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem2255 extends LeetcodeProblem {

    int countPrefixes(String[] _words, String _s) {
        return (int) Arrays.stream(_words).filter(_s::startsWith).count();
    }

}
