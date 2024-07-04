package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0754 extends LeetcodeProblem {

    int reachNumber(int _target) {
        int absTarget = Math.abs(_target);
        int steps = 1;
        int sum = 0;
        while (sum < absTarget || (sum - absTarget) % 2 == 1) {
            sum += steps;
            steps++;
        }
        return steps - 1;
    }

}
