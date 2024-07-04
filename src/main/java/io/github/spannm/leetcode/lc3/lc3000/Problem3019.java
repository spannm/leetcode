package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3019. Number of Changing Keys.
 */
class Problem3019 extends LeetcodeProblem {

    int countKeyChanges(String _s) {
        int ans = 0;
        for (int i = 1; i < _s.length(); i++) {
            if (Character.toLowerCase(_s.charAt(i)) != Character.toLowerCase(_s.charAt(i - 1))) {
                ++ans;
            }
        }
        return ans;
    }

}
