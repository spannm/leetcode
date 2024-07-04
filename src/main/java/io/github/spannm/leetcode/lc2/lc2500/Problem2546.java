package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2546. Apply Bitwise Operations to Make Strings Equal.
 */
class Problem2546 extends LeetcodeProblem {

    boolean makeStringsEqual(String s, String target) {
        return s.contains("1") == target.contains("1");
    }

}
