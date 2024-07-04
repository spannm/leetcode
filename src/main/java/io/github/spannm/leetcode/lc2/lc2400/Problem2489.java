package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2489. Number of Substrings With Fixed Ratio.
 */
class Problem2489 extends LeetcodeProblem {

    long fixedRatio(String s, int num1, int num2) {
        long n0 = 0;
        long n1 = 0;
        long ans = 0;
        Map<Long, Long> cnt = new HashMap<>();
        cnt.put(0L, 1L);
        for (char c : s.toCharArray()) {
            n0 += c == '0' ? 1 : 0;
            n1 += c == '1' ? 1 : 0;
            long x = n1 * num1 - n0 * num2;
            ans += cnt.getOrDefault(x, 0L);
            cnt.put(x, cnt.getOrDefault(x, 0L) + 1);
        }
        return ans;
    }

}
