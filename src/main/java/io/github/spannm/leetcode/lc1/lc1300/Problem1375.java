package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1375 extends LeetcodeProblem {

    int numTimesAllBlue(int[] _light) {
        int blues = 0;
        int[] status = new int[_light.length];
        for (int i = 0; i < _light.length; i++) {
            status[_light[i] - 1] = 1;
            if (checkAllBlues(status, i)) {
                blues++;
            }
        }
        return blues;
    }

    private boolean checkAllBlues(int[] _status, int _endIndex) {
        for (int i = 0; i <= _endIndex; i++) {
            if (_status[i] != 1) {
                return false;
            }
        }
        return true;
    }

}
