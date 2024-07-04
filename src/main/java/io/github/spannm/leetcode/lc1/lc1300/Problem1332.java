package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1332 extends LeetcodeProblem {

    int removePalindromeSub(String _s) {
        if (_s.isEmpty()) {
            return 0;
        } else if (_s.contentEquals(new StringBuilder(_s).reverse())) {
            return 1;
        }
        return 2;
    }

}
