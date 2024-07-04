package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1111. Maximum Nesting Depth of Two Valid Parentheses Strings.
 */
class Problem1111 extends LeetcodeProblem {

    int[] maxDepthAfterSplit(String _seq) {
        int n = _seq.length();
        int[] ans = new int[n];
        for (int i = 0, x = 0; i < n; i++) {
            if (_seq.charAt(i) == '(') {
                ans[i] = x++ & 1;
            } else {
                ans[i] = --x & 1;
            }
        }
        return ans;
    }

}
