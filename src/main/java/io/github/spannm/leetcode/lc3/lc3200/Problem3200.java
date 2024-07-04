package io.github.spannm.leetcode.lc3.lc3200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3200. Maximum Height of a Triangle.
 */
class Problem3200 extends LeetcodeProblem {

    int maxHeightOfTriangle(int _red, int _blue) {
        int result = 0;
        for (int k = 0; k < 2; k++) {
            int[] c = {_red, _blue};
            for (int i = 1, j = k; i <= c[j]; j ^= 1, i++) {
                c[j] -= i;
                result = Math.max(result, i);
            }
        }
        return result;
    }

}
