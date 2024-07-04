package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1936 extends LeetcodeProblem {

    int addRungs(int[] _rungs, int _dist) {
        int addons = 0;
        int currentHeight = 0;
        for (int i = 0; i < _rungs.length;) {
            int nextRung = _rungs[i];
            if (nextRung - currentHeight <= _dist) {
                currentHeight = nextRung;
                i++;
            } else {
                int adds = (nextRung - currentHeight - 1) / _dist;
                addons += adds;
                currentHeight += _dist * adds;
            }
        }
        return addons;
    }

}
