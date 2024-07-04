package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

/**
 * 1862. Sum of Floored Pairs.
 */
class Problem1862 extends LeetcodeProblem {

    int sumOfFlooredPairs(int[] _nums) {
        int mod = 1000000007;
        int max = IntStream.of(_nums).max().orElse(0);
        int[] cnt = new int[max + 1];
        int[] s = new int[max + 1];
        for (int x : _nums) {
            cnt[x]++;
        }
        for (int i = 1; i <= max; ++i) {
            s[i] = s[i - 1] + cnt[i];
        }
        long ans = 0;
        for (int y = 1; y <= max; ++y) {
            if (cnt[y] > 0) {
                for (int d = 1; d * y <= max; ++d) {
                    ans += 1L * cnt[y] * d * (s[Math.min(max, d * y + y - 1)] - s[d * y - 1]);
                    ans %= mod;
                }
            }
        }
        return (int) ans;
    }

}
