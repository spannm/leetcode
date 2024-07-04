package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1739. Building Boxes.
 */
class Problem1739 extends LeetcodeProblem {

    int minimumBoxes(int n) {
        int s = 0;
        int k = 1;
        while (s + k * (k + 1) / 2 <= n) {
            s += k * (k + 1) / 2;
            k++;
        }
        k--;
        int ans = k * (k + 1) / 2;
        k = 1;
        while (s < n) {
            ans++;
            s += k;
            k++;
        }
        return ans;
    }

}
