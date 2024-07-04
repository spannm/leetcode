package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2131. Longest Palindrome by Concatenating Two Letter Words.
 */
class Problem2131 extends LeetcodeProblem {

    int longestPalindrome(String[] words) {
        Map<String, Integer> cnt = new HashMap<>();
        for (var w : words) {
            cnt.put(w, cnt.getOrDefault(w, 0) + 1);
        }
        int ans = 0;
        int x = 0;
        for (var e : cnt.entrySet()) {
            var k = e.getKey();
            var rk = new StringBuilder(k).reverse().toString();
            int v = e.getValue();
            if (k.charAt(0) == k.charAt(1)) {
                x += v & 1;
                ans += v / 2 * 2 * 2;
            } else {
                ans += Math.min(v, cnt.getOrDefault(rk, 0)) * 2;
            }
        }
        ans += x > 0 ? 2 : 0;
        return ans;
    }

}
