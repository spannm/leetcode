package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1624 extends LeetcodeProblem {

    int maxLengthBetweenEqualCharacters(String _s) {
        int maxLen = -1;
        for (int i = 0; i < _s.length(); i++) {
            char c = _s.charAt(i);
            int lastIdx = _s.lastIndexOf(c);
            if (lastIdx != i) {
                maxLen = Math.max(maxLen, Math.abs(lastIdx - i - 1));
            }
        }
        return maxLen;
    }

}
