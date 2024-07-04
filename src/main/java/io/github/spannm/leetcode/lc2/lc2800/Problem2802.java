package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2802. Find The K-th Lucky Number.
 */
class Problem2802 extends LeetcodeProblem {

    String kthLuckyNumber(int k) {
        int n = 1;
        while (k > 1 << n) {
            k -= 1 << n;
            n++;
        }
        StringBuilder ans = new StringBuilder();
        while (n-- > 0) {
            if (k <= 1 << n) {
                ans.append('4');
            } else {
                ans.append('7');
                k -= 1 << n;
            }
        }
        return ans.toString();
    }

}
