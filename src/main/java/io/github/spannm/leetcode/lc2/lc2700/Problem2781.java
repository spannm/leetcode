package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.List;

/**
 * 2781. Length of the Longest Valid Substring.
 */
class Problem2781 extends LeetcodeProblem {

    int longestValidSubstring(String word, List<String> forbidden) {
        var s = new HashSet<>(forbidden);
        int ans = 0;
        int n = word.length();
        for (int i = 0, j = 0; j < n; j++) {
            for (int k = j; k > Math.max(j - 10, i - 1); k--) {
                if (s.contains(word.substring(k, j + 1))) {
                    i = k + 1;
                    break;
                }
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

}
