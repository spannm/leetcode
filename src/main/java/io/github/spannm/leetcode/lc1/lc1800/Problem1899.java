package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1899. Merge Triplets to Form Target Triplet.
 */
class Problem1899 extends LeetcodeProblem {

    boolean mergeTriplets(int[][] triplets, int[] target) {
        int x = target[0];
        int y = target[1];
        int z = target[2];
        int d = 0;
        int e = 0;
        int f = 0;
        for (var t : triplets) {
            int a = t[0];
            int b = t[1];
            int c = t[2];
            if (a <= x && b <= y && c <= z) {
                d = Math.max(d, a);
                e = Math.max(e, b);
                f = Math.max(f, c);
            }
        }
        return d == x && e == y && f == z;
    }

}
