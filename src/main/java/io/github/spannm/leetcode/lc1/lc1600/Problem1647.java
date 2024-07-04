package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/"> 1647. Minimum
 * Deletions to Make Character Frequencies Unique</a>.
 */
class Problem1647 extends LeetcodeProblem {

    int minDeletions(String _s) {
        int[] freq = new int[26];
        for (char c : _s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);

        int res = 0;
        for (int i = 24; i >= 0; i--) {
            if (freq[i] == 0) {
                break;
            } else if (freq[i] >= freq[i + 1]) {
                int count = freq[i] - freq[i + 1] + 1;
                freq[i] -= count;
                res += count;
                if (freq[i] < 0) {
                    res += freq[i];
                }
            }
        }
        freq = null;

        return res;
    }

}
