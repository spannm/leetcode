package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2427 extends LeetcodeProblem {

    int commonFactors(int _a, int _b) {
        int ans = 1;
        int num = 2;
        while (num <= _a && num <= _b) {
            if (_a % num == 0 && _b % num == 0) {
                ans++;
            }
            num++;
        }
        return ans;
    }

}
