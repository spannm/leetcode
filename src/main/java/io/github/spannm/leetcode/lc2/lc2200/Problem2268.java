package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2268. Minimum Number of Keypresses.
 */
class Problem2268 extends LeetcodeProblem {

    int minimumKeypresses(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        Arrays.sort(cnt);
        int ans = 0;
        for (int i = 1, j = 1; i <= 26; i++) {
            ans += j * cnt[26 - i];
            if (i % 9 == 0) {
                j++;
            }
        }
        return ans;
    }

}
