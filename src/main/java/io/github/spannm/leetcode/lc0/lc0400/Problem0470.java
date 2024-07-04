package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Random;

/**
 * 470. Implement Rand10() Using Rand7().
 */
class Problem0470 extends LeetcodeProblem {

    int rand10() {
        while (true) {
            int i = rand7() - 1;
            int j = rand7();
            int x = i * 7 + j;
            if (x <= 40) {
                return x % 10 + 1;
            }
        }
    }

    static int rand7() {
        return new Random(System.currentTimeMillis()).nextInt(7);
    }

}
