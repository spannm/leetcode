package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2516. Take K of Each Character From Left and Right.
 */
class Problem2516 extends LeetcodeProblem {

    int takeCharacters(String s, int k) {
        int[] cnt = new int[3];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            ++cnt[s.charAt(i) - 'a'];
        }
        if (cnt[0] < k || cnt[1] < k || cnt[2] < k) {
            return -1;
        }
        int ans = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            cnt[c]--;
            while (cnt[c] < k) {
                ++cnt[s.charAt(j++) - 'a'];
            }
            ans = Math.max(ans, i - j + 1);
        }
        return n - ans;
    }

}
