package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1237 extends LeetcodeProblem {

    abstract static class CustomFunction {
        public abstract int f(int _x, int _y);
    }

    List<List<Integer>> findSolution(CustomFunction _customfunction, int _z) {
        List<List<Integer>> result = new ArrayList<>();
        for (int x = 1; x <= 1000; x++) {
            for (int y = 1; y <= 1000; y++) {
                if (_customfunction.f(x, y) == _z) {
                    result.add(List.of(x, y));
                }
            }
        }
        return result;
    }

}
