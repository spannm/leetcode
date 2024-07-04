package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2645. Minimum Additions to Make Valid String.
 */
class Problem2645 extends LeetcodeProblem {

    int addMinimum(String word) {
        String s = "abc";
        int ans = 0;
        int n = word.length();
        for (int i = 0, j = 0; j < n; i = (i + 1) % 3) {
            if (word.charAt(j) != s.charAt(i)) {
                ans++;
            } else {
                j++;
            }
        }
        if (word.charAt(n - 1) != 'c') {
            ans += word.charAt(n - 1) == 'b' ? 1 : 2;
        }
        return ans;
    }

}
