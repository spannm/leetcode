package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 3012. Minimize Length of Array Using Operations.
 */
class Problem3012 extends LeetcodeProblem {

    int minimumArrayLength(int[] _nums) {
        int min = Arrays.stream(_nums).min().getAsInt();
        int cnt = 0;
        for (int x : _nums) {
            if (x % min != 0) {
                return 1;
            }
            if (x == min) {
                cnt++;
            }
        }
        return (cnt + 1) / 2;
    }

}
