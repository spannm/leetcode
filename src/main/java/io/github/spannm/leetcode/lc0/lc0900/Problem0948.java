package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 948. Bag of Tokens.
 */
class Problem0948 extends LeetcodeProblem {

    int bagOfTokensScore(int[] _tokens, int _power) {
        Arrays.sort(_tokens);
        int i = 0;
        int j = _tokens.length - 1;
        int result = 0;
        int t = 0;
        while (i <= j) {
            if (_power >= _tokens[i]) {
                _power -= _tokens[i++];
                t++;
                result = Math.max(result, t);
            } else if (t > 0) {
                _power += _tokens[j--];
                t--;
            } else {
                break;
            }
        }
        return result;
    }

}
