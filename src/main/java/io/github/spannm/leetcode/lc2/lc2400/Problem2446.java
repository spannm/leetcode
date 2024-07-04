package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2446. Determine if Two Events Have Conflict.
 */
class Problem2446 extends LeetcodeProblem {

    boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[0].compareTo(event2[1]) > 0 || event1[1].compareTo(event2[0]) < 0);
    }

}
