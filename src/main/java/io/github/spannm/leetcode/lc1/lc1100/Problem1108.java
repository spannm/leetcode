package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1108 extends LeetcodeProblem {

    String defangIPaddr(String _address) {

        return _address.replaceAll("\\.", "\\[\\.\\]");
    }

}
