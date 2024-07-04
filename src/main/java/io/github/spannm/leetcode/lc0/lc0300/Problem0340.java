package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/"> 340. Longest Substring
 * with At Most K Distinct Characters</a>.
 */
class Problem0340 extends LeetcodeProblem {

    int lengthOfLongestSubstringKDistinct(String _s, int _k) {
        int[] count = new int[256];
        int left = 0;
        int res = 0;
        int num = 0;
        for (int right = 0; right < _s.length(); right++) {
            if (count[_s.charAt(right)]++ == 0) {
                num++;
            }
            if (num > _k) {
                while (--count[_s.charAt(left)] > 0) {
                    left++;
                }
                num--;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

}
