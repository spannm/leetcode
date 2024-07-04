package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2515 extends LeetcodeProblem {

    int closetTarget(String[] _words, String _target, int _startIndex) {
        int ans = _words.length;
        if (_words[_startIndex].equals(_target)) {
            return 0;
        }

        int forwardSteps = 1;
        for (int i = (_startIndex + 1) % _words.length; i != _startIndex; i = (i + 1) % _words.length) {
            if (_words[i].equals(_target)) {
                ans = Math.min(ans, forwardSteps);
                break;
            }
            forwardSteps++;
        }

        int backwardSteps = 1;
        for (int i = (_startIndex - 1 + _words.length) % _words.length; i != _startIndex; i = (i - 1 + _words.length) % _words.length) {
            if (_words[i].equals(_target)) {
                ans = Math.min(ans, backwardSteps);
                break;
            }
            backwardSteps++;
        }
        return ans == _words.length ? -1 : ans;
    }

}
