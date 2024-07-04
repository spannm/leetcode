package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Collections;
import java.util.List;

/**
 * 2790. Maximum Number of Groups With Increasing Length.
 */
class Problem2790 extends LeetcodeProblem {

    int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits);
        int k = 0;
        long s = 0;
        for (int x : usageLimits) {
            s += x;
            if (s > k) {
                k++;
                s -= k;
            }
        }
        return k;
    }

}
