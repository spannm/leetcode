package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/pascals-triangle-ii/">119. Pascal's Triangle II</a>.
 */
class Problem0119 extends LeetcodeProblem {

    List<Integer> getRow(final int _rowIndex) {
        if (_rowIndex < 0) {
            return List.of();
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        for (int i = 1; i <= _rowIndex; i++) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            List<Integer> lastRow = result.get(i - 1);
            for (int j = 1; j < lastRow.size(); j++) {
                newRow.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            newRow.add(1);
            result.add(newRow);
        }

        List<Integer> row = result.get(result.size() - 1);
        result = null;
        return row;
    }

}
