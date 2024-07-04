package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2224. Minimum Number of Operations to Convert Time.
 */
class Problem2224 extends LeetcodeProblem {

    int convertTime(String current, String correct) {
        int a = Integer.parseInt(current.substring(0, 2)) * 60
            + Integer.parseInt(current.substring(3));
        int b = Integer.parseInt(correct.substring(0, 2)) * 60
            + Integer.parseInt(correct.substring(3));
        int ans = 0;
        int d = b - a;
        for (int i : Arrays.asList(60, 15, 5, 1)) {
            ans += d / i;
            d %= i;
        }
        return ans;
    }

}
