package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/pascals-triangle/">118. Pascal's Triangle</a>.
 */
class Problem0118 extends LeetcodeProblem {

    List<List<Integer>> generate(final int _numRows) {
        List<List<Integer>> rslt = new ArrayList<>(_numRows);
        for (int rowIdx = 0; rowIdx < _numRows; rowIdx++) {
            int nbCells = 1 + rowIdx;
            List<Integer> row = new ArrayList<>(nbCells);
            rslt.add(row);
            for (int cellIdx = 0; cellIdx < nbCells; cellIdx++) {
                if (cellIdx == 0 || cellIdx == nbCells - 1) {
                    row.add(cellIdx, 1);
                } else {
                    List<Integer> prevRow = rslt.get(rowIdx - 1);
                    row.add(cellIdx, prevRow.get(cellIdx - 1) + prevRow.get(cellIdx));
                }
            }
        }
        return rslt;
    }

}
