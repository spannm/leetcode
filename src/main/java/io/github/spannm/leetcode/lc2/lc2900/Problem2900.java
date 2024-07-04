package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 2900. Longest Unequal Adjacent Groups Subsequence I.
 */
class Problem2900 extends LeetcodeProblem {

    List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0 || groups[i] != groups[i - 1]) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

}
