package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2938. Separate Black and White Balls.
 */
class Problem2938 extends LeetcodeProblem {

    long minimumSteps(String s) {
        long ans = 0;
        int cnt = 0;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                cnt++;
                ans += n - i - cnt;
            }
        }
        return ans;
    }

}
