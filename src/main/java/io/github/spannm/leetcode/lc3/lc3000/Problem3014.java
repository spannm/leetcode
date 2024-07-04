package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3014. Minimum Number of Pushes to Type Word I.
 */
class Problem3014 extends LeetcodeProblem {

    int minimumPushes(String _word) {
        int len = _word.length();
        int ans = 0;
        int k = 1;
        for (int i = 0; i < len / 8; i++) {
            ans += k * 8;
            k++;
        }
        ans += k * (len % 8);
        return ans;
    }

}
