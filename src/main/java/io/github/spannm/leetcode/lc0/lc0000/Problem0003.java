package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">3. Longest Substring Without
 * Repeating Characters</a>.
 */
class Problem0003 extends LeetcodeProblem {

    int lengthOfLongestSubstring(String _s) {
        final int strLen = _s == null ? 0 : _s.length();
        if (strLen <= 1) {
            if (strLen == 0) {
                return 0;
            }
            return 1;
        }

        final char[] arr = _s.toCharArray();
        // array of character counts (large enough for ascii table)
        final int[] firstEncounters = new int[128];
        java.util.Arrays.fill(firstEncounters, -1);

        int subLen = 0;
        int maxSubLen = 0;

        for (int i = 0; i < strLen; i++) {
            if (firstEncounters[arr[i]] > -1) { // seen before
                maxSubLen = Math.max(maxSubLen, subLen);
                i = firstEncounters[arr[i]]; // reset index to first encounter of character causing duplicate to restart
                                             // the loop at beginning of next substring
                java.util.Arrays.fill(firstEncounters, -1);
                // count current character which is start of new sequence
                subLen = 0;
            } else {
                firstEncounters[arr[i]] = i;
                subLen++;
            }
        }

        return Math.max(maxSubLen, subLen);
    }

}
