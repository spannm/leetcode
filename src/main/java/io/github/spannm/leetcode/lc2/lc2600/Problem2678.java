package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2678. Number of Senior Citizens.
 */
class Problem2678 extends LeetcodeProblem {

    int countSeniors(String[] details) {
        int ans = 0;
        for (var x : details) {
            int age = Integer.parseInt(x.substring(11, 13));
            if (age > 60) {
                ans++;
            }
        }
        return ans;
    }

}
