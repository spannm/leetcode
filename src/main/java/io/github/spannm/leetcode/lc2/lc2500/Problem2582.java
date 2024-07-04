package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2582 extends LeetcodeProblem {

    int passThePillow(int _n, int _time) {
        int person = 1;
        boolean goLeft = true;
        while (_time-- > 0) {
            if (goLeft) {
                person++;
            } else {
                person--;
            }
            if (_time == 0) {
                return person;
            } else if (person == _n || person == 1) {
                goLeft = !goLeft;
            }
        }
        return person;
    }

}
