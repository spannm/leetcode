package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2579. Count Total Number of Colored Cells.
 */
class Problem2579 extends LeetcodeProblem {

    long coloredCells(int n) {
        return 2L * n * (n - 1) + 1;
    }

}
