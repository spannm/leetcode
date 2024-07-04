package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 984. String Without AAA or BBB.
 */
class Problem0984 extends LeetcodeProblem {

    String strWithout3a3b(int _a, int _b) {
        StringBuilder ans = new StringBuilder();
        while (_a > 0 && _b > 0) {
            if (_a > _b) {
                ans.append("aab");
                _a -= 2;
                _b -= 1;
            } else if (_a < _b) {
                ans.append("bba");
                _a -= 1;
                _b -= 2;
            } else {
                ans.append("ab");
                _a--;
                _b--;
            }
        }
        if (_a > 0) {
            ans.append("a".repeat(_a));
        }
        if (_b > 0) {
            ans.append("b".repeat(_b));
        }
        return ans.toString();
    }

}
