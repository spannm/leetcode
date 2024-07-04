package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2315 extends LeetcodeProblem {

    int countAsterisks(String _s) {
        int ans = 0;
        for (int i = 0; i < _s.length(); i++) {
            if (_s.charAt(i) == '|') {
                i++;
                while (i < _s.length() && _s.charAt(i) != '|') {
                    i++;
                }
            } else if (_s.charAt(i) == '*') {
                ans++;
            }
        }
        return ans;
    }

}
