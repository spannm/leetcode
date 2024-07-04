package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0159 extends LeetcodeProblem {

    int lengthOfLongestSubstringTwoDistinct(String _s) {
        if (_s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> index = new HashMap<>();
        int lo = 0;
        int hi = 0;
        int maxLength = 0;
        while (hi < _s.length()) {
            if (index.size() <= 2) {
                char c = _s.charAt(hi);
                index.put(c, hi);
                hi++;
            }
            if (index.size() > 2) {
                int leftMost = _s.length();
                for (int i : index.values()) {
                    leftMost = Math.min(leftMost, i);
                }
                char c = _s.charAt(leftMost);
                index.remove(c);
                lo = leftMost + 1;
            }
            maxLength = Math.max(maxLength, hi - lo);
        }
        return maxLength;
    }

}
