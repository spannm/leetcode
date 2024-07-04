package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/strobogrammatic-number-ii/">247. Strobogrammatic Number II</a>.
 */
class Problem0247 extends LeetcodeProblem {

    List<String> findStrobogrammatic(int _n) {
        return recursiveHelper(_n, _n);
    }

    static List<String> recursiveHelper(int _n, int _m) {
        if (_n == 0) {
            return List.of("");
        } else if (_n == 1) {
            return List.of("0", "1", "8");
        }

        List<String> list = recursiveHelper(_n - 2, _m);
        List<String> res = new ArrayList<>();

        for (String s : list) {
            if (_n != _m) {
                res.add("0" + s + "0");
            }
            res.addAll(List.of(
                "1" + s + "1",
                "6" + s + "9",
                "8" + s + "8",
                "9" + s + "6"));
        }
        return res;
    }

}
