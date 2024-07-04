package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2644. Find the Maximum Divisibility Score.
 */
class Problem2644 extends LeetcodeProblem {

    int maxDivScore(int[] nums, int[] divisors) {
        int ans = divisors[0];
        int mx = 0;
        for (int div : divisors) {
            int cnt = 0;
            for (int x : nums) {
                if (x % div == 0) {
                    cnt++;
                }
            }
            if (mx < cnt) {
                mx = cnt;
                ans = div;
            } else if (mx == cnt) {
                ans = Math.min(ans, div);
            }
        }
        return ans;
    }

}
