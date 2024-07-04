package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/triangle/">120. Triangle</a>.
 */
class Problem0120 extends LeetcodeProblem {

    int minimumTotal(List<List<Integer>> _triangle) {
        if (_triangle.isEmpty()) {
            return 0;
        }
        for (int row1 = _triangle.size() - 2; row1 >= 0; row1--) {
            for (int row2 = 0; row2 <= row1; row2++) {
                int newVal = _triangle.get(row1).get(row2)
                    + Math.min(_triangle.get(row1 + 1).get(row2), _triangle.get(row1 + 1).get(row2 + 1));
                _triangle.get(row1).set(row2, newVal);
            }
        }
        return _triangle.get(0).get(0);
    }

}
