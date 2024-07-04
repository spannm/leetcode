package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/reorganize-string/">767. Reorganize String</a>.
 */
class Problem0767 extends LeetcodeProblem {

    String reorganizeString(final String _s) {
        final int len = _s.length();

        int[] freq = new int[26]; // to Store Frequency of each alphabet
        char[] arr = _s.toCharArray();

        int max = 0;
        int letter = 0;
        for (int i = 0; i < len; i++) { // store the frequency
            int idx = arr[i] - 'a';
            freq[idx]++;
            if (freq[idx] > max) { // find the max frequency
                max = freq[idx];
                letter = idx;
            }
        }

        if (max > (len + 1) / 2) {
            return ""; // if max is more than half then not possible
        }

        int idx = 0;
        char[] res = new char[len];

        while (freq[letter] > 0) { // distribute the max freq char into even indices
            res[idx] = (char) (letter + 'a');
            idx += 2;
            freq[letter]--;
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                if (idx >= len) {
                    idx = 1; // all even indices filled, so switch to odd indices
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                freq[i]--;
            }

        }

        final String result = String.valueOf(res);

        freq = null;
        arr = null;
        res = null;
        System.gc();

        return result;
    }

}
