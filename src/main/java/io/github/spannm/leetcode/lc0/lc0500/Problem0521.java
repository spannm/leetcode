package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0521 extends LeetcodeProblem {

    int findLUSlength(String _a, String _b) {
        return _a.equals(_b) ? -1 : Math.max(_a.length(), _b.length());
    }

}
