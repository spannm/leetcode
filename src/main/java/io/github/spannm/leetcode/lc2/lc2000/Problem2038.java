package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2038 extends LeetcodeProblem {

    boolean winnerOfGame(String _colors) {
        int ans = 0;
        for (int i = 1; i < _colors.length() - 1; i++) {
            if (_colors.charAt(i) == _colors.charAt(i - 1) && _colors.charAt(i) == _colors.charAt(i + 1)) {
                if (_colors.charAt(i) == 'A') {
                    ans++;
                } else {
                    ans--;
                }
            }
        }
        return ans > 0;
    }

}
