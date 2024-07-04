package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 3016. Minimum Number of Pushes to Type Word II.
 */
class Problem3016 extends LeetcodeProblem {

    int minimumPushes(String _word) {
        int[] cnt = new int[26];
        for (int i = 0; i < _word.length(); i++) {
            cnt[_word.charAt(i) - 'a']++;
        }
        Arrays.sort(cnt);
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += (i / 8 + 1) * cnt[26 - i - 1];
        }
        return ans;
    }

}
