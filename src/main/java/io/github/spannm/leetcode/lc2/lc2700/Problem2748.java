package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2748. Number of Beautiful Pairs.
 */
class Problem2748 extends LeetcodeProblem {

    int countBeautifulPairs(int[] nums) {
        int[] cnt = new int[10];
        int ans = 0;
        for (int x : nums) {
            for (int y = 0; y < 10; y++) {
                if (cnt[y] > 0 && gcd(x % 10, y) == 1) {
                    ans += cnt[y];
                }
            }
            while (x > 9) {
                x /= 10;
            }
            cnt[x]++;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
