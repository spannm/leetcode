package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0386 extends LeetcodeProblem {

    List<Integer> lexicalOrder(int _n) {
        List<Integer> result = new ArrayList<>();
        int i = 1;
        while (true) {
            result.add(i);
            if (i * 10 <= _n) {
                i *= 10;
            } else {
                while (i % 10 == 9 || i == _n) {
                    i /= 10;
                }
                if (i == 0) {
                    return result;
                }
                i++;
            }
        }
    }

}
