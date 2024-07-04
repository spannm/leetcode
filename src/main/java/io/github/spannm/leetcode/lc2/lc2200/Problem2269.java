package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2269 extends LeetcodeProblem {

    int divisorSubstrings(int _num, int _k) {
        String numStr = String.valueOf(_num);
        int ans = 0;
        for (int i = 0; i + _k <= numStr.length(); i++) {
            String candidate = numStr.substring(i, i + _k);
            int integer = Integer.parseInt(candidate);
            if (integer == 0) {
                continue;
            }
            if (_num % integer == 0) {
                ans++;
            }
        }
        return ans;
    }

}
