package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0424 extends LeetcodeProblem {

    int characterReplacement(final String _s, final int _k) {
        int len = _s.length();
        int[] count = new int[26];
        int start = 0;
        int maxCount = 0;
        int maxLen = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[_s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > _k) {
                count[_s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

}
