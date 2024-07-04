package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Problem0970 extends LeetcodeProblem {

    List<Integer> powerfulIntegers(int _x, int _y, int _bound) {
        int powerInteger;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= _bound; i++) {
            for (int j = 0; j <= _bound; j++) {
                powerInteger = (int) (Math.pow(_x, i) + Math.pow(_y, j));
                if (powerInteger <= _bound) {
                    set.add(powerInteger);
                } else {
                    break;
                }
                if (_y == 1) {
                    break;
                }
            }
            if (_x == 1) {
                break;
            }
        }
        return new ArrayList<>(set);
    }

}
